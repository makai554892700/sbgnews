package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;
import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.common.conf.enums.BaseResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.BSBDJConf;
import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.common.exception.BaseException;
import com.mayousheng.www.sbgnews.common.sort.BSBDJComparator;
import com.mayousheng.www.sbgnews.mapper.*;
import com.mayousheng.www.sbgnews.pojo.*;
import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.service.NewsDescService;
import com.mayousheng.www.sbgnews.utils.BSBDJPojoUtils;
import com.mayousheng.www.sbgnews.utils.HttpUtils;
import com.mayousheng.www.sbgnews.utils.RC4Utils;
import com.mayousheng.www.sbgnews.utils.UserUtils;
import com.mayousheng.www.sbgnews.vo.response.PhotoResponse;
import com.mayousheng.www.sbgnews.vo.response.PunsterResponse;
import com.mayousheng.www.sbgnews.vo.response.VideoResponse;
import com.mayousheng.www.sbgnews.vo.response.VoiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service("bsbdjServiceImpl")
public class BSBDJServiceImpl implements BSBDJService {

    private static boolean isInitOk;
    private Logger log = LoggerFactory.getLogger(BSBDJServiceImpl.class);

    @Resource(name = "defaultUserConf")
    private DefaultUserConf defaultUserConf;
    @Resource(name = "bsbdjConf")
    private BSBDJConf bsbdjConf;
    @Resource(name = "userMapperImpl")
    private UserMapper userMapper;
    @Resource(name = "photoBSBDJMapper")
    private PhotoBSBDJMapper photoBSBDJMapper;
    @Resource(name = "punsterBSBDJMapper")
    private PunsterBSBDJMapper punsterBSBDJMapper;
    @Resource(name = "videoBSBDJMapper")
    private VideoBSBDJMapper videoBSBDJMapper;
    @Resource(name = "voiceBSBDJMapper")
    private VoiceBSBDJMapper voiceBSBDJMapper;
    @Resource(name = "newsDescServiceImpl")
    private NewsDescService newsDescService;

    @Override
    public void setLoaded(boolean loaded) {
        isInitOk = loaded;
    }

    @Override
    public List<BSBDJBack> loadData() {
        List<BSBDJBack> result = new ArrayList<>();
        for (Integer type : bsbdjConf.getTypes()) {
            result.add(loadDataByPage(type, bsbdjConf.getDefaultPage()));
            try {
                Thread.sleep(bsbdjConf.getInitSleepTime());
            } catch (Exception e) {
            }
        }
        return result;
    }

    @Override
    public List<PhotoResponse> getPhotoBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        List<PhotoBSBDJ> photoBSBDJList = photoBSBDJMapper.getPhotoBySearch(
                bsbdjLimit.getCount(), bsbdjLimit.getCount() * bsbdjLimit.getPage());
        if (photoBSBDJList == null || photoBSBDJList.isEmpty()) {
            throw new BaseException(BaseResultEnum.NO_DATA);
        }
        return photoBSBDJs2PhotoResponses(photoBSBDJList);
    }

    @Override
    public List<PunsterResponse> getPunsterBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        List<PunsterBSBDJ> punsterBSBDJList = punsterBSBDJMapper.getPunsterBySearch(
                bsbdjLimit.getCount(), bsbdjLimit.getCount() * bsbdjLimit.getPage());
        if (punsterBSBDJList == null || punsterBSBDJList.isEmpty()) {
            throw new BaseException(BaseResultEnum.NO_DATA);
        }
        return punsterBSBDJs2PunsterResponses(punsterBSBDJList);
    }

    @Override
    public List<VoiceResponse> getVoiceBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        List<VoiceBSBDJ> voiceBSBDJList = voiceBSBDJMapper.getVoiceBySearch(
                bsbdjLimit.getCount(), bsbdjLimit.getCount() * bsbdjLimit.getPage());
        if (voiceBSBDJList == null || voiceBSBDJList.isEmpty()) {
            throw new BaseException(BaseResultEnum.NO_DATA);
        }
        return voiceBSBDJs2VoiceResponses(voiceBSBDJList);
    }

    @Override
    public List<VideoResponse> getVideoBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        List<VideoBSBDJ> videoBSBDJList = videoBSBDJMapper.getVideoBySearch(
                bsbdjLimit.getCount(), bsbdjLimit.getCount() * bsbdjLimit.getPage());
        if (videoBSBDJList == null || videoBSBDJList.isEmpty()) {
            throw new BaseException(BaseResultEnum.NO_DATA);
        }
        return videoBSBDJs2VideoResponses(videoBSBDJList);
    }

    @Override
    @Async("defaultAsync")
    public void loadAllDatas() throws Exception {
        log.error("isInitOk=" + isInitOk);
        if (!isInitOk) {
            for (Integer type : bsbdjConf.getTypes()) {
                BSBDJBack bsbdjBack;
                int currentPage = 0;
                boolean haveNext;
                do {
                    log.error("Loading current Page=" + currentPage);
                    bsbdjBack = loadDataByPage(type, currentPage--);
                    if (bsbdjBack != null) {
                        if (currentPage < 0) {
                            currentPage = bsbdjBack.getShowapiResBody().getPagebean().getAllPages();
                            haveNext = true;
                        } else {
                            haveNext = currentPage > 0;
                        }
                    } else {
                        log.error("bsbdjBack is null.");
                        haveNext = false;
                    }
                    Thread.sleep(bsbdjConf.getInitSleepTime());
                }
                while (haveNext);
            }
            isInitOk = true;
        }
    }

    private BSBDJBack loadDataByPage(Integer type, Integer page) {
        byte[] tempData = HttpUtils.getInstance().getURLResponse(
                String.format(bsbdjConf.getBaseurl(), type, page), null);
        if (tempData == null) {
            return null;
        }
        String tempStr = new String(tempData, Charset.forName("UTF-8"));
//        log.error("Start load bsbdj tempStr=" + tempStr);
        BSBDJBack bsbdjBack = JSONObject.parseObject(tempStr, BSBDJBack.class);
        if (!bsbdjConf.getShowapiResCode().equals(bsbdjBack.getShowapiResCode())) {
            return null;
        }
        BSBDJBack.BSBDJBody bsbdjBody = bsbdjBack.getShowapiResBody();
        if (!bsbdjConf.getRetCode().equals(bsbdjBody.getRetCode())) {
            return null;
        }
        BaseShowApiResBody<BSBDJ> showApiResBody = bsbdjBody.getPagebean();
        if (showApiResBody == null) {
            return null;
        }
        List<BSBDJ> bsbdjList = showApiResBody.getContentlist();
        if (bsbdjList == null) {
            return null;
        }
        bsbdjList.sort(new BSBDJComparator());
        switch (type) {
            case 10://图片
                savePhotoBSBDJ(bsbdjList);
                break;
            case 29://段子
                savePunsterBSBDJ(bsbdjList);
                break;
            case 31://声音
                saveVoiceBSBDJ(bsbdjList);
                break;
            case 41://视频
                saveVideoBSBDJ(bsbdjList);
                break;
            default:
                return null;
        }
        return bsbdjBack;
    }

    private void savePhotoBSBDJ(List<BSBDJ> bsbdjList) {
        PhotoBSBDJ tempPhotoBSBDJ;
        PhotoBSBDJ tempDBPhotoBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempPhotoBSBDJ = BSBDJPojoUtils.BSBDJ2PhotoBSBDJ(bsbdj);
            tempDBPhotoBSBDJ = photoBSBDJMapper.getPhotoBSBDJByMark(tempPhotoBSBDJ.getMark());
            if (tempDBPhotoBSBDJ == null) {
                tempPhotoBSBDJ.setUserId(saveUserAndGetId(bsbdj));
                tempPhotoBSBDJ.setText(RC4Utils.bytesToHexString(tempPhotoBSBDJ.getText().getBytes()));
                try {
                    photoBSBDJMapper.save(tempPhotoBSBDJ);
                } catch (Exception e) {
                    log.error("e=" + e + ";tempPhotoBSBDJ=" + tempPhotoBSBDJ);
                }
            }
        }
    }

    private void savePunsterBSBDJ(List<BSBDJ> bsbdjList) {
        PunsterBSBDJ tempPunsterBSBDJ;
        PunsterBSBDJ tempDBPunsterBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempPunsterBSBDJ = BSBDJPojoUtils.BSBDJ2PunsterBSBDJ(bsbdj);
            tempDBPunsterBSBDJ = punsterBSBDJMapper.getPunsterBSBDJByMark(tempPunsterBSBDJ.getMark());
            if (tempDBPunsterBSBDJ == null) {
                tempPunsterBSBDJ.setUserId(saveUserAndGetId(bsbdj));
                tempPunsterBSBDJ.setText(RC4Utils.bytesToHexString(tempPunsterBSBDJ.getText().getBytes()));
                try {
                    punsterBSBDJMapper.save(tempPunsterBSBDJ);
                } catch (Exception e) {
                    log.error("e=" + e + ";tempPunsterBSBDJ=" + tempPunsterBSBDJ);
                }
            }
        }
    }

    private void saveVideoBSBDJ(List<BSBDJ> bsbdjList) {
        VideoBSBDJ tempVideoBSBDJ;
        VideoBSBDJ tempDBVideoBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempVideoBSBDJ = BSBDJPojoUtils.BSBDJ2VideoBSBDJ(bsbdj);
            tempDBVideoBSBDJ = videoBSBDJMapper.getVideoBSBDJByMark(tempVideoBSBDJ.getMark());
            if (tempDBVideoBSBDJ == null) {
                tempVideoBSBDJ.setUserId(saveUserAndGetId(bsbdj));
                tempVideoBSBDJ.setText(RC4Utils.bytesToHexString(tempVideoBSBDJ.getText().getBytes()));
                try {
                    videoBSBDJMapper.save(tempVideoBSBDJ);
                } catch (Exception e) {
                    log.error("e=" + e + ";tempVideoBSBDJ=" + tempVideoBSBDJ);
                }
            }
        }
    }

    private void saveVoiceBSBDJ(List<BSBDJ> bsbdjList) {
        VoiceBSBDJ tempVoiceBSBDJ;
        VoiceBSBDJ tempDBVoiceBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempVoiceBSBDJ = BSBDJPojoUtils.BSBDJ2VoiceBSBDJ(bsbdj);
            tempDBVoiceBSBDJ = voiceBSBDJMapper.getVoiceBSBDJByMark(tempVoiceBSBDJ.getMark());
            if (tempDBVoiceBSBDJ == null) {
                tempVoiceBSBDJ.setUserId(saveUserAndGetId(bsbdj));
                tempVoiceBSBDJ.setText(RC4Utils.bytesToHexString(tempVoiceBSBDJ.getText().getBytes()));
                try {
                    voiceBSBDJMapper.save(tempVoiceBSBDJ);
                } catch (Exception e) {
                    log.error("e=" + e + ";tempVoiceBSBDJ=" + tempVoiceBSBDJ);
                }
            }
        }
    }

    private int saveUserAndGetId(BSBDJ bsbdj) {
        User tempUser = BSBDJPojoUtils.BSBDJ2User(bsbdj);
        User tempDBUser = userMapper.getUserByUserName(tempUser.getUserName());
        if (tempDBUser == null) {
            try {
                return userMapper.save(tempUser).getId();
            } catch (Exception e) {
                log.error("e=" + e);
            }
            return -1;
        } else {
            return tempDBUser.getId();
        }
    }


    private PhotoResponse photoBSBDJ2PhotoResponse(PhotoBSBDJ photoBSBDJ) {
        if (photoBSBDJ == null) {
            return null;
        }
        User user = userMapper.findOne(photoBSBDJ.getId());
        if (user == null) {
            user = defaultUserConf.getUser();
        }
        return new PhotoResponse(photoBSBDJ.getMark(), newsDescService.getNewsDesc(
                photoBSBDJ.getCreateTime(), photoBSBDJ.getId(), StaticParam.TABLE_NAME_PHOTOBSBDJ)
                , UserUtils.user2UserDesc(user), photoBSBDJ.getText(), photoBSBDJ.getCdnImg());
    }

    private List<PhotoResponse> photoBSBDJs2PhotoResponses(List<PhotoBSBDJ> photoBSBDJList) {
        if (photoBSBDJList == null) {
            return null;
        }
        List<PhotoResponse> photoResponseList = new ArrayList<>();
        for (PhotoBSBDJ photoBSBDJ : photoBSBDJList) {
            photoResponseList.add(photoBSBDJ2PhotoResponse(photoBSBDJ));
        }
        return photoResponseList;
    }

    private PunsterResponse punsterBSBDJ2PunsterResponse(PunsterBSBDJ punsterBSBDJ) {
        if (punsterBSBDJ == null) {
            return null;
        }
        User user = userMapper.findOne(punsterBSBDJ.getId());
        if (user == null) {
            user = defaultUserConf.getUser();
        }
        return new PunsterResponse(punsterBSBDJ.getMark(), newsDescService.getNewsDesc(
                punsterBSBDJ.getCreateTime(), punsterBSBDJ.getId(), StaticParam.TABLE_NAME_PUNSTERBSBDJ)
                , UserUtils.user2UserDesc(user), punsterBSBDJ.getText());
    }

    private List<PunsterResponse> punsterBSBDJs2PunsterResponses(List<PunsterBSBDJ> punsterBSBDJList) {
        if (punsterBSBDJList == null) {
            return null;
        }
        List<PunsterResponse> punsterResponseList = new ArrayList<>();
        for (PunsterBSBDJ punsterBSBDJ : punsterBSBDJList) {
            punsterResponseList.add(punsterBSBDJ2PunsterResponse(punsterBSBDJ));
        }
        return punsterResponseList;
    }

    private VideoResponse videoBSBDJ2VideoResponse(VideoBSBDJ videoBSBDJ) {
        if (videoBSBDJ == null) {
            return null;
        }
        User user = userMapper.findOne(videoBSBDJ.getId());
        if (user == null) {
            user = defaultUserConf.getUser();
        }
        return new VideoResponse(videoBSBDJ.getMark(), newsDescService.getNewsDesc(
                videoBSBDJ.getCreateTime(), videoBSBDJ.getId(), StaticParam.TABLE_NAME_VIDEOBSBDJ)
                , UserUtils.user2UserDesc(user), videoBSBDJ.getText(), videoBSBDJ.getVideoUri());
    }

    private List<VideoResponse> videoBSBDJs2VideoResponses(List<VideoBSBDJ> videoBSBDJList) {
        if (videoBSBDJList == null) {
            return null;
        }
        List<VideoResponse> videoResponseList = new ArrayList<>();
        for (VideoBSBDJ videoBSBDJ : videoBSBDJList) {
            videoResponseList.add(videoBSBDJ2VideoResponse(videoBSBDJ));
        }
        return videoResponseList;
    }

    private VoiceResponse voiceBSBDJ2VoiceResponse(VoiceBSBDJ voiceBSBDJ) {
        if (voiceBSBDJ == null) {
            return null;
        }
        User user = userMapper.findOne(voiceBSBDJ.getId());
        if (user == null) {
            user = defaultUserConf.getUser();
        }
        return new VoiceResponse(voiceBSBDJ.getMark(), newsDescService.getNewsDesc(
                voiceBSBDJ.getCreateTime(), voiceBSBDJ.getId(), StaticParam.TABLE_NAME_VOICEBSBDJ)
                , UserUtils.user2UserDesc(user), voiceBSBDJ.getText(), voiceBSBDJ.getVoiceuri(), voiceBSBDJ.getCdnImg());
    }

    private List<VoiceResponse> voiceBSBDJs2VoiceResponses(List<VoiceBSBDJ> voiceBSBDJList) {
        if (voiceBSBDJList == null) {
            return null;
        }
        List<VoiceResponse> voiceResponseList = new ArrayList<>();
        for (VoiceBSBDJ voiceBSBDJ : voiceBSBDJList) {
            voiceResponseList.add(voiceBSBDJ2VoiceResponse(voiceBSBDJ));
        }
        return voiceResponseList;
    }
}

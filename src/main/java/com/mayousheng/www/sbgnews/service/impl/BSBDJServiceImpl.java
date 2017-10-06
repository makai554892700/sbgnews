package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;
import com.mayousheng.www.sbgnews.common.conf.pojo.BSBDJConf;
import com.mayousheng.www.sbgnews.common.sort.BSBDJComparator;
import com.mayousheng.www.sbgnews.mapper.*;
import com.mayousheng.www.sbgnews.pojo.*;
import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.utils.BSBDJPojoUtils;
import com.mayousheng.www.sbgnews.utils.HttpUtils;
import com.mayousheng.www.sbgnews.vo.response.VideoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service("bsbdjServiceImpl")
public class BSBDJServiceImpl implements BSBDJService {

    //    private static boolean isInitOk = false;
    private Logger log = LoggerFactory.getLogger(BSBDJServiceImpl.class);

    @Resource(name = "bsbdjConf")
    private BSBDJConf bsbdjConf;
    @Resource(name = "deviceMapper")
    private DeviceMapper deviceMapper;
    @Resource(name = "userMapper")
    private UserMapper userMapper;
    @Resource(name = "photoBSBDJMapper")
    private PhotoBSBDJMapper photoBSBDJMapper;
    @Resource(name = "punsterBSBDJMapper")
    private PunsterBSBDJMapper punsterBSBDJMapper;
    @Resource(name = "videoBSBDJMapper")
    private VideoBSBDJMapper videoBSBDJMapper;
    @Resource(name = "voiceBSBDJMapper")
    private VoiceBSBDJMapper voiceBSBDJMapper;

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
    public List<VideoResponse> getPhotoBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        return null;
    }

    @Override
    public List<VideoResponse> getPunsterBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        return null;
    }

    @Override
    public List<VideoResponse> getVoiceBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        return null;
    }

    @Override
    public List<VideoResponse> getVideoBySearch(BSBDJLimit bsbdjLimit) throws Exception {
        return null;
    }

    @Override
    public void loadAllDatas() throws Exception {

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

    public void savePhotoBSBDJ(List<BSBDJ> bsbdjList) {
        User tempUser;
        PhotoBSBDJ tempPhotoBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempUser = BSBDJPojoUtils.BSBDJ2User(bsbdj);

            tempPhotoBSBDJ = BSBDJPojoUtils.BSBDJ2PhotoBSBDJ(bsbdj);
        }
    }

    private void savePunsterBSBDJ(List<BSBDJ> bsbdjList) {
        User tempUser;
        PunsterBSBDJ tempPunsterBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempUser = BSBDJPojoUtils.BSBDJ2User(bsbdj);
        }
    }

    private void saveVideoBSBDJ(List<BSBDJ> bsbdjList) {
        User tempUser;
        VideoBSBDJ tempVideoBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempUser = BSBDJPojoUtils.BSBDJ2User(bsbdj);
        }
    }

    private void saveVoiceBSBDJ(List<BSBDJ> bsbdjList) {
        User tempUser;
        VoiceBSBDJ tempVoiceBSBDJ;
        for (BSBDJ bsbdj : bsbdjList) {
            tempUser = BSBDJPojoUtils.BSBDJ2User(bsbdj);
        }
    }
}

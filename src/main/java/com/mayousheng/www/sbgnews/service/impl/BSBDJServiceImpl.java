package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;
import com.mayousheng.www.sbgnews.common.conf.pojo.BSBDJConf;
import com.mayousheng.www.sbgnews.common.sort.BSBDJComparator;
import com.mayousheng.www.sbgnews.pojo.BSBDJ;
import com.mayousheng.www.sbgnews.pojo.BSBDJBack;
import com.mayousheng.www.sbgnews.pojo.BSBDJLimit;
import com.mayousheng.www.sbgnews.service.BSBDJService;
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
        log.error("Start load bsbdj tempStr=" + tempStr);
        BSBDJBack bsbdjBack = JSONObject.parseObject(tempStr, BSBDJBack.class);
        log.error("bsbdjBack=" + bsbdjBack);
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
        BSBDJ tempBSBDJ;
        bsbdjList.sort(new BSBDJComparator());
        log.error("bsbdjList=" + bsbdjList);
        for (BSBDJ bsbdj : bsbdjList) {
//            tempBSBDJ = jokesMapper.getJokesByTitle(bsbdj.getTitle());
//            if (tempBSBDJ != null) {
//                continue;
//            }
//            try {
//                jokesMapper.save(bsbdj);
//            } catch (Exception e) {
//                log.error("loadJokes e=" + e);
//            }
        }
        return bsbdjBack;
    }
}

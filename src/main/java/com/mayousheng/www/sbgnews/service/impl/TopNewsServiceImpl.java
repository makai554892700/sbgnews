package com.mayousheng.www.sbgnews.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mayousheng.www.sbgnews.common.conf.enums.ResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.TopNewsConf;
import com.mayousheng.www.sbgnews.common.exception.TopNewsException;
import com.mayousheng.www.sbgnews.mapper.TopNewsMapper;
import com.mayousheng.www.sbgnews.pojo.TopNews;
import com.mayousheng.www.sbgnews.pojo.TopNewsBack;
import com.mayousheng.www.sbgnews.pojo.TopNewsSearch;
import com.mayousheng.www.sbgnews.service.TopNewsService;
import com.mayousheng.www.sbgnews.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

@Service("topNewsServiceImpl")
public class TopNewsServiceImpl implements TopNewsService {

    private Logger log = LoggerFactory.getLogger(TopNewsServiceImpl.class);

    @Resource(name = "topNewsMapper")
    private TopNewsMapper topNewsMapper;

    @Resource(name = "topNewsConf")
    private TopNewsConf topNewsConf;

    @Override
    public void loadNews() {
        TopNewsBack tempTopNewsBack;
        TopNewsBack.Result tempResult;
        TopNews tempDBTopNews;
        byte[] tempData;
        String tempUrl;
        String tempStr;
        for (String type : topNewsConf.getTypes()) {
            tempUrl = String.format(topNewsConf.getBaseurl(), type);
            tempData = HttpUtils.getInstance().getURLResponse(tempUrl, (HashMap<String, String>) topNewsConf.getHeard());
            if (tempData == null) {
                continue;
            }
            tempStr = new String(tempData, Charset.forName("UTF-8"));
            log.error("Start load news tempUrl=" + tempUrl + ";tempStr=" + tempStr);
            tempTopNewsBack = JSONObject.parseObject(tempStr, TopNewsBack.class);
            if (tempTopNewsBack.getError_code() != topNewsConf.getSuccessCode().intValue()) {
                continue;
            }
            tempResult = tempTopNewsBack.getResult();
            if (!topNewsConf.getSuccessStat().equals(tempResult.getStat())) {
                continue;
            }
            for (TopNews topNews : tempResult.getData()) {
                topNews.setType(type);
                tempDBTopNews = topNewsMapper.getTopNewsByUniquekey(topNews.getUniquekey());
                if (tempDBTopNews != null) {
                    continue;
                }
                topNewsMapper.save(topNews);
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public List<TopNews> getNewsBySearch(@Valid TopNewsSearch topNewsSearch) throws Exception {
        if (!topNewsConf.getTypes().contains(topNewsSearch.getType())) {
            throw new TopNewsException(ResultEnum.TOP_NEWS_NO_TYPE);
        }
        List<TopNews> result = topNewsMapper.getNewsBySearch(topNewsSearch.getType(),
                topNewsSearch.getCount() * topNewsSearch.getPage(),
                topNewsSearch.getCount());
        if (result == null || result.isEmpty()) {
            throw new TopNewsException(ResultEnum.TOP_NEWS_NO_DATA);
        }
        return result;
    }
}

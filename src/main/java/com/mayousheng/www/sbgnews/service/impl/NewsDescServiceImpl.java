package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.NewsOperateMapper;
import com.mayousheng.www.sbgnews.pojo.operate.NewsOperate;
import com.mayousheng.www.sbgnews.service.NewsDescService;
import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("newsDescServiceImpl")
public class NewsDescServiceImpl implements NewsDescService {

    private Logger log = LoggerFactory.getLogger(NewsDescServiceImpl.class);

    @Resource(name = "newsOperateMapper")
    private NewsOperateMapper newsOperateMapper;

    @Override
    public NewsDesc getNewsDesc(String createTime, Integer newsId, String tableName) {
        NewsOperate newsOperate = newsOperateMapper.getNewsOperateByTableNameAndNewsId(tableName
                , newsId);
        if (newsOperate == null) {
            return null;
        }
        return new NewsDesc(newsOperate.getLove(), newsOperate.getHate(), newsOperate.getShare()
                , newsOperate.getComment(), newsId, tableName, createTime);
    }
}

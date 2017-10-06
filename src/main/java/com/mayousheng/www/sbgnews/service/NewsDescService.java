package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.vo.response.base.NewsDesc;

public interface NewsDescService {

    public NewsDesc getNewsDesc(String createTime, Integer descId, String tableName);

}

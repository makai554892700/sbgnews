package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.TopNews;
import com.mayousheng.www.sbgnews.pojo.TopNewsSearch;

import java.util.List;

public interface TopNewsService {

    public void loadNews();

    public List<TopNews> getNewsBySearch(TopNewsSearch topNewsSearch) throws Exception;

}

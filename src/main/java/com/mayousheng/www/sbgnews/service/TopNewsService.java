package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.vo.request.TopNewsSearch;
import com.mayousheng.www.sbgnews.vo.response.TopNewsResponse;

import java.util.List;

public interface TopNewsService {

    public void loadNews();

    public List<TopNewsResponse> getNewsBySearch(TopNewsSearch topNewsSearch) throws Exception;

}

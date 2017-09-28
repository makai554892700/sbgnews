package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.TopNewsApi;
import com.mayousheng.www.sbgnews.common.conf.pojo.TopNewsConf;
import com.mayousheng.www.sbgnews.vo.response.Result;
import com.mayousheng.www.sbgnews.vo.request.TopNewsSearch;
import com.mayousheng.www.sbgnews.service.TopNewsService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.vo.response.TopNewsResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class TopNewsController implements TopNewsApi {

    @Resource(name = "topNewsServiceImpl")
    private TopNewsService topNewsService;

    @Resource(name = "topNewsConf")
    private TopNewsConf topNewsConf;

    @Override
    public Result<Map<String, String>> getNewsTypes() throws Exception {// http://localhost:8080/topnews/getNewsTypes
        return ResultUtils.succeed(topNewsConf.getTypes());
    }

    @Override
    public Result<List<TopNewsResponse>> getNews(@RequestBody @Valid TopNewsSearch topNewsSearch) throws Exception { // http://localhost:8080/topnews/getNews {"type":"top","count":10,"page":1}
        return ResultUtils.succeed(topNewsService.getNewsBySearch(topNewsSearch));
    }

}

package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.common.conf.pojo.TopNewsConf;
import com.mayousheng.www.sbgnews.pojo.Result;
import com.mayousheng.www.sbgnews.pojo.TopNews;
import com.mayousheng.www.sbgnews.pojo.TopNewsSearch;
import com.mayousheng.www.sbgnews.service.TopNewsService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topnews")
public class TopNewsController {

    @Resource(name = "topNewsServiceImpl")
    private TopNewsService topNewsService;

    @Resource(name = "topNewsConf")
    private TopNewsConf topNewsConf;

    @GetMapping("getNewsTypes")
    public Result<List<String>> getNewsTypes() throws Exception {// http://localhost:8080/topnews/getNewsTypes
        return ResultUtils.succeed(topNewsConf.getTypes());
    }

    @PostMapping("getNews")
    public Result<List<TopNews>> getNews(@RequestBody @Valid TopNewsSearch topNewsSearch) throws Exception { // http://localhost:8080/topnews/getNews {"type":"top","count":10,"page":1}
        return ResultUtils.succeed(topNewsService.getNewsBySearch(topNewsSearch));
    }

}

package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.vo.request.TopNewsSearch;
import com.mayousheng.www.sbgnews.vo.response.Result;
import com.mayousheng.www.sbgnews.vo.response.TopNewsResponse;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RequestMapping("/topnews")
@Api(value = "头条新闻")
public interface TopNewsApi {

    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("getNewsTypes")
    @ApiOperation(value = "获取类型", notes = "获取类型", tags = {"topnews"})
    public Result<Map<String, String>> getNewsTypes() throws Exception;// http://localhost:8080/topnews/getNewsTypes

    @PostMapping("getNews")
    @ApiOperation( value = "根据查找信息获取新闻", notes = "根据查找信息获取新闻", tags = {"topnews"})
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    public Result<List<TopNewsResponse>> getNews(@RequestBody @Valid TopNewsSearch topNewsSearch) throws Exception; // http://localhost:8080/topnews/getNews {"type":"top","count":10,"page":1}

}

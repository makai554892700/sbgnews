package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.vo.request.NewsCommentRequest;
import com.mayousheng.www.sbgnews.vo.request.NewsOperateRequest;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/operate")
@Api(value = "新闻操作")
public interface OperateApi {

    @PostMapping(value = "/love")
    @ApiOperation(value = "喜欢这则新闻", notes = "喜欢这则新闻"
            , tags = {"operate"})
    @RequiresAuthentication
    // http://localhost:8080/api/operate/love
    // {"newsMark":1,"newsType":"photobsbdj"}
    public Result<String> love(@RequestBody @Valid NewsOperateRequest newsMark
            , BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/hate")
    @ApiOperation(value = "讨厌这则新闻", notes = "讨厌这则新闻"
            , tags = {"operate"})
    @RequiresAuthentication
    // http://localhost:8080/api/operate/hate
    // {"newsMark":2,"newsType":"photobsbdj"}
    public Result<String> hate(@RequestBody @Valid NewsOperateRequest newsMark
            , BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/share")
    @ApiOperation(value = "分享了这则新闻", notes = "分享了这则新闻"
            , tags = {"operate"})
    @RequiresAuthentication
    // http://localhost:8080/api/operate/share
    // {"newsMark":3,"newsType":"photobsbdj"}
    public Result<String> share(@RequestBody @Valid NewsOperateRequest newsMark
            , BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/comment")
    @ApiOperation(value = "评论这则新闻", notes = "评论这则新闻"
            , tags = {"operate"})
    @RequiresAuthentication
    // http://localhost:8080/api/operate/comment
    // {newsMark:{"newsMark":5,"newsType":"photobsbdj"},"commentInfo":"什么都可以"}
    public Result<String> comment(@RequestBody @Valid NewsCommentRequest newsComment
            , BindingResult bindingResult) throws Exception;

}

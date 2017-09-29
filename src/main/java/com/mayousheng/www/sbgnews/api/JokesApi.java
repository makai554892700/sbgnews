package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/jokes")
@Api(value = "搞笑文本")
public interface JokesApi {

    @GetMapping("/getJokes/{count}/{page}")
    @ApiOperation(value = "根据查找信息获取搞笑文本", notes = "根据查找信息获取搞笑文本", tags = {"jokes"})
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    // http://localhost:8080/jokes/getJokes/10/1
    public Result<List<JokeResponse>> getJokes(@PathVariable("count") Integer count
            , @PathVariable("page") Integer page) throws Exception;

}

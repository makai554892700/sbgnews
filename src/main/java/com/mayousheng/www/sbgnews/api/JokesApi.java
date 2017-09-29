package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/jokes")
@Api(value = "搞笑文本")
public interface JokesApi {

    @GetMapping("getJokes/{count}/{page}")
    @ApiOperation(value = "根据查找信息获取搞笑文本", notes = "根据查找信息获取搞笑文本", tags = {"jokes"})
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    // http://localhost:8080/jokes/getJokes/10/1
    public Result<List<JokeResponse>> getJokes(@RequestParam("count") Integer count
            , @RequestParam("page") Integer page) throws Exception;

}

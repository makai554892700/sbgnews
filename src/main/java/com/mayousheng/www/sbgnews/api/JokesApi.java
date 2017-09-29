package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;
import io.swagger.annotations.*;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/jokes")
@Api(value = "搞笑文本")
public interface JokesApi {

    @PostMapping(value = "/getJokes")
    @ApiOperation(value = "根据查找信息获取搞笑文本", notes = "根据查找信息获取搞笑文本", tags = {"jokes"})
    @ApiResponses({
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    // http://localhost:8080/jokes/getJokes {"count":10,"page":0}
    public Result<List<JokeResponse>> getJokes(@RequestBody @Valid JokeLimit jokeLimit, BindingResult bindingResult) throws Exception;

}

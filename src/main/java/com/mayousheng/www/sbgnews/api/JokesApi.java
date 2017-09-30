package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @PutMapping(value = "loadAllJokes")
    @ApiOperation(value = "加载搞笑文本源所有数据，初始化时使用", notes = "加载搞笑文本源所有数据", tags = {"jokes"})
    public Result<String> loadAllJokes() throws Exception;

}

package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.JokesApi;
import com.mayousheng.www.sbgnews.pojo.joke.JokeLimit;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import com.mayousheng.www.sbgnews.service.JokeService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class JokesController implements JokesApi {

    @Resource(name = "jokeServiceImpl")
    private JokeService jokeService;

    @Override
    public Result<List<JokeResponse>> getJokes(@RequestBody @Valid JokeLimit jokeLimit, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(jokeService.getJokesBySearch(jokeLimit));
    }
}

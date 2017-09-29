package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.JokesApi;
import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;
import com.mayousheng.www.sbgnews.service.JokeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class JokesController implements JokesApi {

    @Resource(name = "jokeServiceImpl")
    private JokeService jokeService;

    @Override
    public Result<List<JokeResponse>> getJokes(@PathVariable("count") Integer count
            , @PathVariable("page") Integer page) throws Exception {
        return ResultUtils.succeed(jokeService.getJokesBySearch(new JokeLimit(count, page)));
    }
}

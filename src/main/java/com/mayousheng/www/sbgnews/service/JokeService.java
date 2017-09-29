package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;

import java.util.List;

public interface JokeService {

    public void loadJokes();

    public List<JokeResponse> getJokesBySearch(JokeLimit jokeLimit) throws Exception;

}
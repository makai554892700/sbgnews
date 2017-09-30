package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.JokeBack;
import com.mayousheng.www.sbgnews.pojo.JokeLimit;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;
import com.mayousheng.www.sbgnews.vo.response.Result;

import java.util.List;

public interface JokeService {

    public JokeBack loadJokes();

    public List<JokeResponse> getJokesBySearch(JokeLimit jokeLimit) throws Exception;

    public void loadAllJokes() throws Exception;

}

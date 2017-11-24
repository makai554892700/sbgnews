package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.joke.JokeBack;
import com.mayousheng.www.sbgnews.pojo.joke.JokeLimit;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;

import java.util.List;

public interface JokeService {

    public JokeBack loadJokes();

    public List<JokeResponse> getJokesBySearch(JokeLimit jokeLimit) throws Exception;

    public void loadAllJokes() throws Exception;

    public void setLoaded(boolean loaded);

}

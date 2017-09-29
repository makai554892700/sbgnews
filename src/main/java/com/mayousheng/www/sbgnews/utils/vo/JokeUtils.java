package com.mayousheng.www.sbgnews.utils.vo;

import com.mayousheng.www.sbgnews.pojo.Joke;
import com.mayousheng.www.sbgnews.vo.response.JokeResponse;

import java.util.ArrayList;
import java.util.List;

public class JokeUtils {

    public static JokeResponse joke2Response(Joke joke) {
        if (joke == null) {
            return null;
        }
        return new JokeResponse(joke.getTitle(), joke.getText(), joke.getCt());
    }

    public static List<JokeResponse> jokes2Responses(List<Joke> jokes) {
        if (jokes == null) {
            return null;
        }
        List<JokeResponse> jokeRespons = new ArrayList<>();
        for (Joke joke : jokes) {
            jokeRespons.add(joke2Response(joke));
        }
        return jokeRespons;
    }

}

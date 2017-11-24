package com.mayousheng.www.sbgnews.common.sort;

import com.mayousheng.www.sbgnews.common.conf.enums.TimeEnum;
import com.mayousheng.www.sbgnews.pojo.joke.Joke;
import com.mayousheng.www.sbgnews.utils.TimeUtils;

import java.util.Comparator;

public class JokeComparator implements Comparator<Joke> {

    public int compare(Joke joke1, Joke joke2) {
        return TimeUtils.sortDESC(TimeUtils.getDateByStr(joke1.getCt(), TimeEnum.FORMAT_DAY_MSEC)
                , TimeUtils.getDateByStr(joke2.getCt(), TimeEnum.FORMAT_DAY_MSEC));
    }
}
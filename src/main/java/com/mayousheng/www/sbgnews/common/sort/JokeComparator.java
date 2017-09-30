package com.mayousheng.www.sbgnews.common.sort;

import com.mayousheng.www.sbgnews.common.conf.enums.TimeEnum;
import com.mayousheng.www.sbgnews.pojo.Joke;
import com.mayousheng.www.sbgnews.utils.TimeUtils;

import java.util.Comparator;
import java.util.Date;

public class JokeComparator implements Comparator<Joke> {

    public int compare(Joke joke1, Joke joke2) {
        Date date1 = TimeUtils.getDateByStr(joke1.getCt(), TimeEnum.FORMAT_DAY_MSEC);
        Date date2 = TimeUtils.getDateByStr(joke2.getCt(), TimeEnum.FORMAT_DAY_MSEC);
        if (date1 != null && date2 != null) {
            if (date1.getTime() < date2.getTime()) {
                return -1;
            }
            if (date1.getTime() > date2.getTime()) {
                return 1;
            }
        }
        return 0;
    }
}
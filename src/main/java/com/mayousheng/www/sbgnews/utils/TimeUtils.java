package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.enums.TimeEnum;
import com.mayousheng.www.sbgnews.common.sort.JokeComparator;
import com.mayousheng.www.sbgnews.pojo.Joke;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;

public class TimeUtils {

    private static final Logger log = LoggerFactory.getLogger(TimeUtils.class);

//    public static void main(String[] args) {
//        String test1 = "2017-09-29 19:30:16.935";
//        String test2 = "2017-09-29 19:10:16.935";
//        String test3 = "2017-09-29 19:20:16.935";
//        System.out.println("date=" + getDateByStr(test1, TimeEnum.FORMAT_DAY_MSEC));
//        List<Joke> jokes = new ArrayList<>();
//        Joke joke1 = new Joke();
//        joke1.setCt(test1);
//        jokes.add(joke1);
//        Joke joke2 = new Joke();
//        joke2.setCt(test2);
//        jokes.add(joke2);
//        Joke joke3 = new Joke();
//        joke3.setCt(test3);
//        jokes.add(joke3);
//        System.out.println("jokes1=" + jokes);
//        jokes.sort(new JokeComparator());
//        System.out.println("jokes2=" + jokes);
//    }

    public static Date getDateByStr(String str, TimeEnum timeEnum) {
        if (str == null || timeEnum == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(timeEnum.getStr());
        try {
            return sdf.parse(str);
        } catch (Exception e) {
            log.error("e=" + e);
        }
        return null;
    }

    public static Date getDateAddDay(Date date, int day) {
        if (day == 0) {
            return new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static String getTimeZoneDateString(Date date, float timeZoneOffset, TimeEnum timeEnum) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }
        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(timeEnum.getStr());
        sdf.setTimeZone(timeZone);
        return sdf.format(date);
    }

}
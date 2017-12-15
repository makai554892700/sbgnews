package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.enums.TimeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class TimeUtils {

    private static final Logger log = LoggerFactory.getLogger(TimeUtils.class);

    private static final String HOURE_MARK = ":";
    private static final String MSEC_MARK = ".";
    private static final String SPLIT_HOURE_MARK = "\\:";
    private static final String SPLIT_MSEC_MARK = "\\.";
    private static final String TIME_REG = "^(\\d+)(" + HOURE_MARK + "[0-5][0-9]){2}" + MSEC_MARK + "(\\d{0,3})$";

    public static int getTimeByStr(String str) {
        if (str == null || !Pattern.matches(TIME_REG, str)) {
            log.error("str is null.or str is not matches.str=" + str);
            return 0;
        }
        String[] tempStr = str.split(SPLIT_HOURE_MARK);
        String[] tempStr2 = tempStr[2].split(SPLIT_MSEC_MARK);
        return (Integer.valueOf(tempStr[0]) * 3600 +
                Integer.valueOf(tempStr[1]) * 60 +
                Integer.valueOf(tempStr2[0])) * 1000 + Integer.valueOf(tempStr2[1]);
    }

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

    public static int sortDESC(Date date1, Date date2) {
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
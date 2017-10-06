package com.mayousheng.www.sbgnews.common.sort;

import com.mayousheng.www.sbgnews.common.conf.enums.TimeEnum;
import com.mayousheng.www.sbgnews.pojo.BSBDJ;
import com.mayousheng.www.sbgnews.pojo.Joke;
import com.mayousheng.www.sbgnews.utils.TimeUtils;

import java.util.Comparator;
import java.util.Date;

public class BSBDJComparator implements Comparator<BSBDJ> {

    public int compare(BSBDJ bsbdj1, BSBDJ bsbdj2) {
        return TimeUtils.sortDESC(TimeUtils.getDateByStr(bsbdj1.getCt(), TimeEnum.FORMAT_DAY_MSEC)
                , TimeUtils.getDateByStr(bsbdj2.getCt(), TimeEnum.FORMAT_DAY_MSEC));
    }
}
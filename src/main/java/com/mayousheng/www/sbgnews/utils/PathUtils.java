package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;

import java.io.File;

public class PathUtils {

    static {
        FileUtils.sureDir(StaticParam.BSBDJ_PATH);
        FileUtils.sureDir(StaticParam.BSBDJ_IMG_PATH);
    }

    public static String getBSBDJImgPath(String fileName) {
        if (fileName == null) {
            return null;
        }
        return StaticParam.BSBDJ_IMG_PATH + File.separator + fileName + StaticParam.PNG_END;
    }

    public static String getBSBDJImgUrl(String fileName) {
        if (fileName == null) {
            return null;
        }
        return StaticParam.BSBDJ_IMG_URL + fileName + StaticParam.PNG_END;
    }

}

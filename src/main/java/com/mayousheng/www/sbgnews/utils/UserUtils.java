package com.mayousheng.www.sbgnews.utils;

public class UserUtils {

    //获取临时用户名(唯一)
    public static String getUserName() {
        return HexUtils.getHexStr(6) + System.currentTimeMillis();
    }

}

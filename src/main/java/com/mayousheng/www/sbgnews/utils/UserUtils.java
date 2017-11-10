package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.UserDesc;

public class UserUtils {

    //获取临时用户名(唯一)
    public static String getUserName() {
        return HexUtils.getHexStr(6) + System.currentTimeMillis();
    }

    public static UserDesc user2UserDesc(User user) {
        if (user == null) {
            return null;
        }
        return new UserDesc(user.getNickName(), user.getImgUrl());
    }

    public static UserResponse user2UserResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(user.getUserName(), user.getNickName(), user.getSex()
                , user.getMsg(), user.getEmail(), user.getPhone(), user.getImgUrl(), user.getPageHome());
    }

}

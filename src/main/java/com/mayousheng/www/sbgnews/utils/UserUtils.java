package com.mayousheng.www.sbgnews.utils;

import com.mayousheng.www.sbgnews.pojo.SessionUser;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.vo.request.UserRequest;
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

    public static User userRequest2User(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        return new User(userRequest.getUserName(), userRequest.getNickName(), userRequest.getSex()
                , userRequest.getMsg(), userRequest.getPassWord(), userRequest.getEmail()
                , userRequest.getPhone(), userRequest.getImgUrl(), userRequest.getPageHome());
    }

    public static UserResponse user2UserResponse(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse(user.getUserName(), user.getNickName(), user.getSex()
                , user.getMsg(), user.getEmail(), user.getPhone(), user.getImgUrl(), user.getPageHome());
    }

    public static SessionUser dbUser2SessionUser(User user) {
        if (user == null) {
            return null;
        }
        return new SessionUser(user.getId(), user.getUserName());
    }

}

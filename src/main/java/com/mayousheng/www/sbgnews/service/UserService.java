package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;

public interface UserService {

    public UserResponse register(User user) throws Exception;

    public UserResponse login(User user, boolean remberMe, int deviceType) throws Exception;

    public UserResponse update(User user) throws Exception;

    public String logout() throws Exception;

}

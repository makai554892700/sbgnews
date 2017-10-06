package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}

package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapperImpl")
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userMapper.save(user);
    }

    @Override
    public User update(User user, boolean updateRole) {
        User dbUser = userMapper.getUserByUserName(user.getUserName());
        if (!StringUtils.isEmpty(user.getImgUrl())) {
            dbUser.setImgUrl(user.getImgUrl());
        }
        if (!StringUtils.isEmpty(user.getNickName())) {
            dbUser.setNickName(user.getNickName());
        }
        if (!StringUtils.isEmpty(user.getPassWord())) {
            dbUser.setPassWord(user.getPassWord());
        }
        if (!StringUtils.isEmpty(user.getEmail())) {
            dbUser.setEmail(user.getEmail());
        }
        if (!StringUtils.isEmpty(user.getMsg())) {
            dbUser.setMsg(user.getMsg());
        }
        if (!StringUtils.isEmpty(user.getPageHome())) {
            dbUser.setPageHome(user.getPageHome());
        }
        if (!StringUtils.isEmpty(user.getSex())) {
            dbUser.setSex(user.getSex());
        }
        if (!StringUtils.isEmpty(user.getPhone())) {
            dbUser.setPhone(user.getPhone());
        }
        if (updateRole && user.getRoles() != null && !user.getRoles().isEmpty()) {
            dbUser.setRoles(user.getRoles());
        }
        return userMapper.save(dbUser);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}

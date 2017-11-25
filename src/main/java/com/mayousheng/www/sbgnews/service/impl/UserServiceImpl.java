package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.common.conf.StaticParam;
import com.mayousheng.www.sbgnews.common.conf.enums.BaseResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.common.exception.BaseException;
import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.utils.UserUtils;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapperImpl")
    private UserMapper userMapper;
    @Resource(name = "defaultUserConf")
    private DefaultUserConf defaultUserConf;

    @Override
    public UserResponse register(User user) throws Exception {
        User dbUser = userMapper.getUserByUserName(user.getUserName());
        if (dbUser == null) {
            user.setRoles(null);
            user.setPassWord(getPass(user.getPassWord()));
            dbUser = userMapper.save(user);
            return UserUtils.user2UserResponse(dbUser);
        } else {
            throw new BaseException(BaseResultEnum.DOUBLE_USER_NAME);
        }
    }

    @Override
    public UserResponse login(User user) throws Exception {
        User dbUser = userMapper.getUserByUserName(user.getUserName());
        if (dbUser == null) {
            throw new BaseException(BaseResultEnum.NO_USER);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), getPass(user.getPassWord()));
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        dbUser = userMapper.getUserByUserName(user.getUserName());
        return UserUtils.user2UserResponse(dbUser);
    }

    @Override
    public UserResponse update(User user) throws Exception {
        User dbUser = userMapper.getUserByUserName(user.getUserName());
        if (dbUser != null) {
            dbUser = update(user, false);
            return UserUtils.user2UserResponse(dbUser);
        } else {
            throw new BaseException(BaseResultEnum.NO_USER);
        }
    }

    @Override
    public String logout() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
        return StaticParam.OK;
    }

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

    public String getPass(String pass) {
        return new SimpleHash(defaultUserConf.getEncrypt(), pass, defaultUserConf.getSalt()).toString();
    }
}

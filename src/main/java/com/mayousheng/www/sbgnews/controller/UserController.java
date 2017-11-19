package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.UserApi;
import com.mayousheng.www.sbgnews.common.conf.enums.BaseResultEnum;
import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.common.exception.BaseException;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.utils.UserUtils;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class UserController implements UserApi {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Resource(name = "defaultUserConf")
    private DefaultUserConf defaultUserConf;

    @Override
    public Result<UserResponse> register(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        User dbUser = userService.getUserByUserName(user.getUserName());
        if (dbUser == null) {
            user.setRoles(null);
            user.setPassWord(getPass(user.getPassWord()));
            dbUser = userService.save(user);
            return ResultUtils.succeed(UserUtils.user2UserResponse(dbUser));
        } else {
            throw new BaseException(BaseResultEnum.DOUBLE_USER_NAME);
        }
    }

    @Override
    public Result<UserResponse> login(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        User dbUser = userService.getUserByUserName(user.getUserName());
        if (dbUser == null) {
            throw new BaseException(BaseResultEnum.NO_USER);
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), getPass(user.getPassWord()));
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        dbUser = userService.getUserByUserName(user.getUserName());
        return ResultUtils.succeed(UserUtils.user2UserResponse(dbUser));
    }

    @Override
    public Result<String> logout() throws Exception {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser != null) {
            currentUser.logout();
        }
        return ResultUtils.succeed(null);
    }

    @Override
    public Result<UserResponse> update(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        User dbUser = userService.getUserByUserName(user.getUserName());
        if (dbUser != null) {
            dbUser = userService.update(user, false);
            return ResultUtils.succeed(UserUtils.user2UserResponse(dbUser));
        } else {
            throw new BaseException(BaseResultEnum.NO_USER);
        }
    }

    public String getPass(String pass) {
        return new SimpleHash(defaultUserConf.getEncrypt(), pass, defaultUserConf.getSalt()).toString();
    }
}

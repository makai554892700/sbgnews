package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.UserApi;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.utils.UserUtils;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
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

    @Override
    public Result<UserResponse> login(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        String username = user.getUserName();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassWord());
        Subject currentUser = SecurityUtils.getSubject();
        log.info("对用户[" + username + "]进行登录验证..验证开始");
        currentUser.login(token);
        log.info("对用户[" + username + "]进行登录验证..验证通过");
        User dbUser = userService.getUserByUserName(user.getUserName());
        return ResultUtils.succeed(UserUtils.user2UserResponse(dbUser));
    }
}

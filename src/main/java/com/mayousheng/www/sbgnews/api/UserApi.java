package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/user")
@Api(value = "用户登录注册")
public interface UserApi {

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登陆", notes = "用户登陆", tags = {"user"})
    // http://localhost:8080/user/login {"userName":"makai554892700","passWord":"marking"}
    public String getVideos(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception;

}

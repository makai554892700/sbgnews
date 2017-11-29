package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.vo.request.UserRequest;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/user")
@Api(value = "用户登录注册")
public interface UserApi {

    @PostMapping(value = "/register")
    @ApiOperation(value = "用户注册", notes = "用户注册", tags = {"user"})
    // http://localhost:8080/api/user/register {"userName":"makai554892700","passWord":"marking"}
    public Result<UserResponse> register(@RequestBody @Valid UserRequest user
            , BindingResult bindingResult) throws Exception;

    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登陆", notes = "用户登陆", tags = {"user"})
    // http://localhost:8080/api/user/login {"userName":"makai554892700","passWord":"marking"}
    public Result<UserResponse> login(@RequestBody @Valid UserRequest user
            , BindingResult bindingResult) throws Exception;

    @GetMapping(value = "/logout")
    @RequiresUser
    @ApiOperation(value = "用户登出", notes = "用户登出", tags = {"user"})
    // http://localhost:8080/api/user/logout
    public Result<String> logout() throws Exception;

    @PostMapping(value = "/update")
    @RequiresUser
    @ApiOperation(value = "用户更新", notes = "用户更新", tags = {"user"})
    // http://localhost:8080/api/user/update {"userName":"makai554892700","passWord":"marking"}
    public Result<UserResponse> update(@RequestBody @Valid UserRequest user
            , BindingResult bindingResult) throws Exception;

}

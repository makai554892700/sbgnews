package com.mayousheng.www.sbgnews.api;

import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.vo.response.UserResponse;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/operate")
@Api(value = "新闻操作")
public interface OperateApi {

    @PostMapping(value = "/love")
    @ApiOperation(value = "喜欢这则新闻", notes = "喜欢这则新闻", tags = {"user"})
    // http://localhost:8080/api/operate/love {"userName":"makai554892700","passWord":"marking"}
    public Result<String> love(@RequestBody @Valid User user, BindingResult bindingResult) throws Exception;

}

package com.mayousheng.www.sbgnews.controller;

import com.mayousheng.www.sbgnews.api.OperateApi;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.OperateService;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import com.mayousheng.www.sbgnews.vo.request.NewsComment;
import com.mayousheng.www.sbgnews.vo.request.NewsMark;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class OperateController implements OperateApi {
    private Logger log = LoggerFactory.getLogger(OperateController.class);

    @Resource(name = "operateServiceImpl")
    private OperateService operateService;

    @Override
    public Result<String> love(@RequestBody @Valid NewsMark newsMark
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(operateService.love(newsMark));
    }

    @Override
    public Result<String> hate(@RequestBody @Valid NewsMark newsMark
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(operateService.hate(newsMark));
    }

    @Override
    public Result<String> share(@RequestBody @Valid NewsMark newsMark
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.succeed(operateService.share(newsMark));
    }

    @Override
    public Result<String> comment(@RequestBody @Valid NewsComment newsComment
            , BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            throw new Exception(bindingResult.getFieldError().getDefaultMessage());
        }
        User user = null;
        return ResultUtils.succeed(operateService.comment(user, newsComment));
    }
}

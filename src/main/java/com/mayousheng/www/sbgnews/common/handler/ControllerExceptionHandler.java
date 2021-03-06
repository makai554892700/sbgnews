package com.mayousheng.www.sbgnews.common.handler;

import com.mayousheng.www.sbgnews.common.exception.BaseException;
import com.mayousheng.www.sbgnews.vo.response.base.Result;
import com.mayousheng.www.sbgnews.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//controller层错误拦截，用于拦截错误页面返回给用户，给用户正确的格式
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result<String> onField(BaseException baseException) {
        return ResultUtils.field(baseException.getCode(), baseException.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<String> onError(Exception e) {
        return ResultUtils.field(e.getMessage());
    }

}

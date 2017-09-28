package com.mayousheng.www.sbgnews.common.exception;

import com.mayousheng.www.sbgnews.common.conf.enums.ResultEnum;

import javax.validation.constraints.NotNull;

//用户异常，用于返回正确的格式及异常码
public class TopNewsException extends RuntimeException {

    private Integer code;

    public TopNewsException(@NotNull ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

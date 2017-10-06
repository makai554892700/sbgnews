package com.mayousheng.www.sbgnews.common.exception;

import com.mayousheng.www.sbgnews.common.conf.enums.BaseResultEnum;

import javax.validation.constraints.NotNull;

//用户异常，用于返回正确的格式及异常码
public class BaseException extends RuntimeException {

    private Integer code;

    public BaseException(@NotNull BaseResultEnum baseResultEnum) {
        super(baseResultEnum.getMsg());
        code = baseResultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

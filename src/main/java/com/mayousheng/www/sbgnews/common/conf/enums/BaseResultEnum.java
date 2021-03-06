package com.mayousheng.www.sbgnews.common.conf.enums;

//返回结果的
public enum BaseResultEnum {
    DATA_ERROR(1, "请求数据出错"),
    NO_USER(2, "用户不存在"),
    DOUBLE_USER_NAME(3, "用户名已被占用"),
    NO_DATA(4, "数据库没有数据"),
    UNKNOW_ERROR(-1, "未知错误");

    private String msg;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    BaseResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

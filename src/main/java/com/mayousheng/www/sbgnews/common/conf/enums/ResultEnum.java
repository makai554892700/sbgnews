package com.mayousheng.www.sbgnews.common.conf.enums;

//返回结果的
public enum ResultEnum {
    NO_DATA(0, "数据库没有数据"),
    DATA_ERROR(1, "请求数据出错"),
    UNKNOW_ERROR(-1, "未知错误");

    private String msg;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    ResultEnum(Integer code, String msg) {
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

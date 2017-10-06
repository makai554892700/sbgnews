package com.mayousheng.www.sbgnews.common.base;

public class BaseShowApiBack<T> {

    private Integer showapiResCode;//接口返回码
    private String showapiResError;//接口错误信息
    private T showapiResBody;//接口数据对象

    public Integer getShowapiResCode() {
        return showapiResCode;
    }

    public void setShowapiResCode(Integer showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    public String getShowapiResError() {
        return showapiResError;
    }

    public void setShowapiResError(String showapiResError) {
        this.showapiResError = showapiResError;
    }

    public T getShowapiResBody() {
        return showapiResBody;
    }

    public void setShowapiResBody(T showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

    @Override
    public String toString() {
        return "BaseShowApiBack{" +
                "showapiResCode=" + showapiResCode +
                ", showapiResError='" + showapiResError + '\'' +
                ", showapiResBody=" + showapiResBody +
                '}';
    }
}

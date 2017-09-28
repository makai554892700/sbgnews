package com.mayousheng.www.sbgnews.pojo;

import java.util.Arrays;
import java.util.Date;

//统计数据对象
public class StatisticObject {

    private String requestUrl;//请求url
    private String requestType;//请求类型
    private String ip;//请求者ip
    private Object[] args;//请求参数
    private String classMethod;//调用方法
    private Object response;//返回参数
    private boolean haveError;//运行过程是否报错
    private long runTime;//方法运行时间
    private Date requestTime;//接口调用时间

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }

    public boolean isHaveError() {
        return haveError;
    }

    public void setHaveError(boolean haveError) {
        this.haveError = haveError;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    @Override
    public String toString() {
        return "StatisticObject{" +
                "requestUrl='" + requestUrl + '\'' +
                ", requestType='" + requestType + '\'' +
                ", ip='" + ip + '\'' +
                ", args=" + Arrays.toString(args) +
                ", classMethod='" + classMethod + '\'' +
                ", response=" + response +
                ", haveError=" + haveError +
                ", runTime=" + runTime +
                ", requestTime=" + requestTime +
                '}';
    }
}

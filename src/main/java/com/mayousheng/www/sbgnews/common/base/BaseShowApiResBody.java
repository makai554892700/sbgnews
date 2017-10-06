package com.mayousheng.www.sbgnews.common.base;

import java.util.List;

public class BaseShowApiResBody<T> {


    private Integer allPages;//总页数
    private Integer retCode;//返回码
    private List<T> contentlist;//返回的对象
    private Integer currentPage;//当前页码
    private Integer allNum;//总条数
    private Integer maxResult;//最大返回结果数

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public List<T> getContentlist() {
        return contentlist;
    }

    public void setContentlist(List<T> contentlist) {
        this.contentlist = contentlist;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    @Override
    public String toString() {
        return "BaseShowApiResBody{" +
                "allPages=" + allPages +
                ", retCode=" + retCode +
                ", contentlist=" + contentlist +
                ", currentPage=" + currentPage +
                ", allNum=" + allNum +
                ", maxResult=" + maxResult +
                '}';
    }
}

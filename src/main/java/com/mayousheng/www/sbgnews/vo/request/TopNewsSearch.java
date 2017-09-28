package com.mayousheng.www.sbgnews.vo.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

//请求查询数据
public class TopNewsSearch {
    //{"type":"top","count":10,"page":1}

    @NotNull
    private String type;

    @NotNull
    @Min(value = 0, message = "获取新闻总数必须大于0")
    @Max(value = 20, message = "获取新闻总数必须小于20")
    private Integer count;

    @NotNull
    @Min(value = 0, message = "获取新闻当前页数必须大于0")
    private Integer page;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "TopNewsSearch{" +
                "type='" + type + '\'' +
                ", count=" + count +
                ", page=" + page +
                '}';
    }
}

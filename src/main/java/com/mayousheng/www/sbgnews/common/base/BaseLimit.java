package com.mayousheng.www.sbgnews.common.base;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BaseLimit {

    @Min(value = 0, message = "Count must between 1 and 100.")
    @Max(value = 100, message = "Count must between 1 and 100.")
    private Integer count;
    @Min(value = 0, message = "Page count must be greater than 0")
    private Integer page;

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
        return "BaseLimit{" +
                "count=" + count +
                ", page=" + page +
                '}';
    }
}

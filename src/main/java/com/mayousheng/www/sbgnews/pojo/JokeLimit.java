package com.mayousheng.www.sbgnews.pojo;

import com.mayousheng.www.sbgnews.common.base.BaseLimit;

public class JokeLimit extends BaseLimit {

    public JokeLimit() {
    }

    public JokeLimit(Integer count, Integer page) {
        setCount(count);
        setPage(page);
    }
}

package com.mayousheng.www.sbgnews.pojo;

import com.mayousheng.www.sbgnews.common.base.BaseLimit;

public class BSBDJLimit extends BaseLimit {

    public BSBDJLimit() {
    }

    public BSBDJLimit(Integer count, Integer page) {
        setCount(count);
        setPage(page);
    }
}

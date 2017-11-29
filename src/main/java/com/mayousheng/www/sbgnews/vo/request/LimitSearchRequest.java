package com.mayousheng.www.sbgnews.vo.request;

import com.mayousheng.www.sbgnews.common.base.BaseLimit;

public class LimitSearchRequest extends BaseLimit {

    public LimitSearchRequest() {
    }

    public LimitSearchRequest(Integer count, Integer page) {
        setCount(count);
        setPage(page);
    }
}

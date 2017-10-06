package com.mayousheng.www.sbgnews.pojo;

import com.mayousheng.www.sbgnews.common.base.BaseShowApiBack;
import com.mayousheng.www.sbgnews.common.base.BaseShowApiResBody;

public class BSBDJBack extends BaseShowApiBack<BSBDJBack.BSBDJBody> {

    public static class BSBDJBody {
        private Integer retCode;
        private BaseShowApiResBody<BSBDJ> pagebean;

        public Integer getRetCode() {
            return retCode;
        }

        public void setRetCode(Integer retCode) {
            this.retCode = retCode;
        }

        public BaseShowApiResBody<BSBDJ> getPagebean() {
            return pagebean;
        }

        public void setPagebean(BaseShowApiResBody<BSBDJ> pagebean) {
            this.pagebean = pagebean;
        }

        @Override
        public String toString() {
            return "BSBDJBody{" +
                    "retCode=" + retCode +
                    ", pagebean=" + pagebean +
                    '}';
        }
    }
}

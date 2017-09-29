package com.mayousheng.www.sbgnews.pojo;

import java.util.List;

//笑话接口返回的对象
public class JokeBack {

    private Integer showapiResCode;//接口返回码
    private String showapiResError;//接口错误信息
    private ShowapiResBody showapiResBody;//接口数据对象

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

    public ShowapiResBody getShowapiResBody() {
        return showapiResBody;
    }

    public void setShowapiResBody(ShowapiResBody showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

    @Override
    public String toString() {
        return "JokeBack{" +
                "showapiResCode=" + showapiResCode +
                ", showapiResError='" + showapiResError + '\'' +
                ", showapiResBody=" + showapiResBody +
                '}';
    }

    public static class ShowapiResBody {

        private Integer allPages;//总页数
        private Integer retCode;//返回码
        private List<Joke> contentlist;//返回的笑话对象
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

        public List<Joke> getContentlist() {
            return contentlist;
        }

        public void setContentlist(List<Joke> contentlist) {
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
            return "ShowapiResBody{" +
                    "allPages=" + allPages +
                    ", retCode=" + retCode +
                    ", contentlist=" + contentlist +
                    ", currentPage=" + currentPage +
                    ", allNum=" + allNum +
                    ", maxResult=" + maxResult +
                    '}';
        }
    }

}

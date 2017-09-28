package com.mayousheng.www.sbgnews.pojo;

import java.util.List;

//头条新闻数据返回对象
public class TopNewsBack {

    private String reason;
    private Integer error_code;
    private Result result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TopNewsBack{" +
                "reason='" + reason + '\'' +
                ", error_code=" + error_code +
                ", result=" + result +
                '}';
    }

    public static class Result {
        private String stat;
        private List<TopNews> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<TopNews> getData() {
            return data;
        }

        public void setData(List<TopNews> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "stat=" + stat +
                    ", data=" + data +
                    '}';
        }
    }

}
//{
//        "reason": "成功的返回",
//        "result": {
//          "stat": "1",
//          "data": [
//              {
//              "uniquekey": "8bc64995d19b787a403164e5d9097d14",
//              "title": "司机驾车途中闻到一股糊味，停车检查发现轮胎中卡着一只国宝",
//              "date": "2017-09-26 21:19",
//              "category": "头条",
//              "author_name": "透透世道",
//              "url": "http://mini.eastday.com/mobile/170926211958961.html",
//              "thumbnail_pic_s": "http://02.imgmini.eastday.com/mobile/20170926/20170926_5503ef6b822e3008bd6c62dd4713f07a_cover_mwpm_03200403.jpg",
//              "thumbnail_pic_s02": "http://02.imgmini.eastday.com/mobile/20170926/20170926_285027748d928f5bde39a55c705ff6ea_cover_mwpm_03200403.jpg",
//              "thumbnail_pic_s03": "http://02.imgmini.eastday.com/mobile/20170926/20170926_45b8b67db5a9f28632c54743992b20e9_cover_mwpm_03200403.jpg"
//              }
//           ]
//        },
//        "error_code": 0
//}
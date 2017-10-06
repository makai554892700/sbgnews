package com.mayousheng.www.sbgnews.common.conf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("jokeConf")
@ConfigurationProperties(prefix = "joke")
public class JokeConf {

    private String baseurl;//请求路径模板
    private Integer showapiResCode;//正确返回码
    private Integer retCode;//正确数据码
    private Integer defaultPage;//默认初始页数
    private Integer defaultCount;//默认结果条数
    private Integer initSleepTime;//初始化请求间隔时间
    private Boolean loaded;//是否初始化过

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public Integer getShowapiResCode() {
        return showapiResCode;
    }

    public void setShowapiResCode(Integer showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public Integer getDefaultPage() {
        return defaultPage;
    }

    public void setDefaultPage(Integer defaultPage) {
        this.defaultPage = defaultPage;
    }

    public Integer getDefaultCount() {
        return defaultCount;
    }

    public void setDefaultCount(Integer defaultCount) {
        this.defaultCount = defaultCount;
    }

    public Integer getInitSleepTime() {
        return initSleepTime;
    }

    public void setInitSleepTime(Integer initSleepTime) {
        this.initSleepTime = initSleepTime;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }

    @Override
    public String toString() {
        return "JokeConf{" +
                "baseurl='" + baseurl + '\'' +
                ", showapiResCode=" + showapiResCode +
                ", retCode=" + retCode +
                ", defaultPage=" + defaultPage +
                ", defaultCount=" + defaultCount +
                ", initSleepTime=" + initSleepTime +
                ", loaded=" + loaded +
                '}';
    }
}

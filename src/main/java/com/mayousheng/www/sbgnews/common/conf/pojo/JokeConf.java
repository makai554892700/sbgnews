package com.mayousheng.www.sbgnews.common.conf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("jokeConf")
@ConfigurationProperties(prefix = "joke")
public class JokeConf {


    private String baseurl;
    private Integer showapiResCode;
    private Integer retCode;
    private Integer sleepTime;

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

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String toString() {
        return "JokeConf{" +
                "baseurl='" + baseurl + '\'' +
                ", showapiResCode=" + showapiResCode +
                ", retCode=" + retCode +
                ", sleepTime=" + sleepTime +
                '}';
    }
}

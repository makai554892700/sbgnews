package com.mayousheng.www.sbgnews.common.conf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component("topNewsConf")
@ConfigurationProperties(prefix = "topnews")
public class TopNewsConf {

    private String baseurl;
    private Map<String, String> types = new HashMap<>();
    private Map<String, String> heard = new HashMap<>();
    private Integer successCode;
    private String successStat;
    private Integer sleepTime;

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }

    public Map<String, String> getTypes() {
        return types;
    }

    public void setTypes(Map<String, String> types) {
        this.types = types;
    }

    public Map<String, String> getHeard() {
        return heard;
    }

    public void setHeard(Map<String, String> heard) {
        this.heard = heard;
    }

    public Integer getSuccessCode() {
        return successCode;
    }

    public void setSuccessCode(Integer successCode) {
        this.successCode = successCode;
    }

    public String getSuccessStat() {
        return successStat;
    }

    public void setSuccessStat(String successStat) {
        this.successStat = successStat;
    }

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String toString() {
        return "TopNewsConf{" +
                "baseurl='" + baseurl + '\'' +
                ", types=" + types +
                ", heard=" + heard +
                ", successCode=" + successCode +
                ", successStat='" + successStat + '\'' +
                ", sleepTime=" + sleepTime +
                '}';
    }
}

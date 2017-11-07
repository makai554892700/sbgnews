package com.mayousheng.www.sbgnews.common.conf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bsbdjConf")
@ConfigurationProperties(prefix = "bsbdj")
public class BSBDJConf {

    private String baseurl;//请求路径模板
    private Integer showapiResCode;//正确返回码
    private Integer retCode;//正确数据码
    private Integer defaultPage;//默认初始页数
    private Integer initSleepTime;//初始化请求间隔时间
    private List<Integer> types;//支持的请求码
    private Boolean loaded;//是否初始化过
    private Integer sleepTime;//请求间隔时间

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

    public Integer getInitSleepTime() {
        return initSleepTime;
    }

    public void setInitSleepTime(Integer initSleepTime) {
        this.initSleepTime = initSleepTime;
    }

    public List<Integer> getTypes() {
        return types;
    }

    public void setTypes(List<Integer> types) {
        this.types = types;
    }

    public Boolean getLoaded() {
        return loaded;
    }

    public void setLoaded(Boolean loaded) {
        this.loaded = loaded;
    }

    public Integer getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Integer sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String toString() {
        return "BSBDJConf{" +
                "baseurl='" + baseurl + '\'' +
                ", showapiResCode=" + showapiResCode +
                ", retCode=" + retCode +
                ", defaultPage=" + defaultPage +
                ", initSleepTime=" + initSleepTime +
                ", types=" + types +
                ", loaded=" + loaded +
                ", sleepTime=" + sleepTime +
                '}';
    }
}

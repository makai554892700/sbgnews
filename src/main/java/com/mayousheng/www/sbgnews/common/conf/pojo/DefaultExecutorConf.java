package com.mayousheng.www.sbgnews.common.conf.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("defaultExecutorConf")
@ConfigurationProperties(prefix = "executor.default")
public class DefaultExecutorConf {

    private Integer corePoolSize;//核心线程数
    private Integer maxPoolSize;//最大线程数
    private Integer queueCapacity;//队列最大长度
    private Integer keepAliveSeconds;//线程池维护线程所允许的空闲时间
    private String threadNamePrefix;//线程名称前缀

    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public Integer getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(Integer queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public Integer getKeepAliveSeconds() {
        return keepAliveSeconds;
    }

    public void setKeepAliveSeconds(Integer keepAliveSeconds) {
        this.keepAliveSeconds = keepAliveSeconds;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }

    @Override
    public String toString() {
        return "DefaultExecutorConf{" +
                "corePoolSize=" + corePoolSize +
                ", maxPoolSize=" + maxPoolSize +
                ", queueCapacity=" + queueCapacity +
                ", keepAliveSeconds=" + keepAliveSeconds +
                ", threadNamePrefix='" + threadNamePrefix + '\'' +
                '}';
    }
}

package com.mayousheng.www.sbgnews.common.thread;

import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultExecutorConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ConfigExecutor {

    @Resource(name = "defaultExecutorConf")
    private DefaultExecutorConf defaultExecutorConf;

    @Bean
    public Executor defaultAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(defaultExecutorConf.getCorePoolSize());
        executor.setMaxPoolSize(defaultExecutorConf.getMaxPoolSize());
        executor.setQueueCapacity(defaultExecutorConf.getQueueCapacity());
        executor.setKeepAliveSeconds(defaultExecutorConf.getKeepAliveSeconds());
        executor.setThreadNamePrefix(defaultExecutorConf.getThreadNamePrefix());
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行  
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}  
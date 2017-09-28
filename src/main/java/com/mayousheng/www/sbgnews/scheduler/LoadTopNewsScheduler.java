package com.mayousheng.www.sbgnews.scheduler;

import com.mayousheng.www.sbgnews.service.TopNewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoadTopNewsScheduler {

    private final static Logger log = LoggerFactory.getLogger(LoadTopNewsScheduler.class);

    @Resource(name = "topNewsServiceImpl")
    private TopNewsService topNewsService;

    @Scheduled(cron = "0 */1 * * * ?")
    public void loadNews() {
        topNewsService.loadNews();
    }

}

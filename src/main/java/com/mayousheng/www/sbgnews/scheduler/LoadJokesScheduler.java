package com.mayousheng.www.sbgnews.scheduler;

import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.service.JokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class LoadJokesScheduler {

    private final static Logger log = LoggerFactory.getLogger(LoadJokesScheduler.class);

    @Resource(name = "jokeServiceImpl")
    private JokeService jokeService;

    @Scheduled(cron = "0 */10 * * * ?")
    public void loadNews() {
        jokeService.loadJokes();
    }

    @Resource(name = "bsbdjServiceImpl")
    private BSBDJService bsbdjService;

    @Scheduled(cron = "30 */10 * * * ?")
    public void loadBSBDJData() {
        bsbdjService.loadData();
    }

}

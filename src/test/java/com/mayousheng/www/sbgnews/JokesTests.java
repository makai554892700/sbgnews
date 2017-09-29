package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.service.JokeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JokesTests {

    private Logger log = LoggerFactory.getLogger(JokesTests.class);

    @Autowired
    private JokeConf jokeConf;

    @Test
    public void testTopNewsConf() {
        log.error("jokeConf=" + jokeConf);
    }

    @Resource(name = "jokeServiceImpl")
    private JokeService jokeService;

    @Test
    public void testTopNewsServiceLoadNews() {
        jokeService.loadJokes();
    }

    @Test
    public void testTopNewsServiceSearch() {

    }
}

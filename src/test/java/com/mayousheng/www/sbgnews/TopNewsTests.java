package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.TopNewsConf;
import com.mayousheng.www.sbgnews.pojo.TopNews;
import com.mayousheng.www.sbgnews.vo.request.TopNewsSearch;
import com.mayousheng.www.sbgnews.service.TopNewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopNewsTests {

    private Logger log = LoggerFactory.getLogger(TopNewsTests.class);


    @Autowired
    private TopNewsConf topNewsConf;

    @Test
    public void testTopNewsConf() {
        log.error("topNewsConf=" + topNewsConf);
    }

    @Resource(name = "topNewsServiceImpl")
    private TopNewsService topNewsService;

    @Test
    public void testTopNewsServiceLoadNews() {
        topNewsService.loadNews();
    }

    @Test
    public void testTopNewsServiceSearch() {
        TopNewsSearch topNewsSearch = new TopNewsSearch();
        topNewsSearch.setType("top");
        topNewsSearch.setPage(2);
        topNewsSearch.setCount(2);
        List<TopNews> topNewsList = null;
        try {
            topNewsList = topNewsService.getNewsBySearch(topNewsSearch);
        } catch (Exception e) {
            log.error("e=" + e);
        } finally {
            log.error("topNewsList=" + topNewsList);
        }
    }
}

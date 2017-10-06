package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.BSBDJConf;
import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.pojo.BSBDJBack;
import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.service.JokeService;
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
public class BSBDJTests {

    private Logger log = LoggerFactory.getLogger(BSBDJTests.class);

    @Autowired
    private BSBDJConf bsbdjConf;

    @Test
    public void testBSBDJConf() {
        log.error("bsbdjConf=" + bsbdjConf);
    }

    @Resource(name = "bsbdjServiceImpl")
    private BSBDJService bsbdjService;

    @Test
    public void testBSBDJServiceLoadData() throws Exception {
        List<BSBDJBack> bsbdjBackList = bsbdjService.loadData();
        if (bsbdjBackList == null || bsbdjBackList.isEmpty()) {
            throw new Exception("bsbdjBackList is null.");
        }
    }

    @Test
    public void testBSBDJServiceLoadAllDatas() throws Exception{
        bsbdjService.loadAllDatas();
    }
}

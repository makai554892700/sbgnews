package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
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
public class UserJTests {

    private Logger log = LoggerFactory.getLogger(UserJTests.class);

    @Autowired
    private DefaultUserConf defaultUserConf;

    @Test
    public void testDefaultUserConf() {
        log.error("defaultUserConf=" + defaultUserConf);
    }

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Test
    public void testBSBDJServiceLoadData() throws Exception {
        User user = userService.getUserByUserName(defaultUserConf.getUser().getUserName());
        if (user == null) {
            throw new Exception("default user is not insert");
        }
    }

}

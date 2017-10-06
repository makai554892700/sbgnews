package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class InitJob {

    private Logger log = LoggerFactory.getLogger(InitJob.class);

    @Autowired
    private DefaultUserConf defaultUserConf;

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @PostConstruct
    public void insetDefaultUser() {
        User user = userMapper.getUserByUserName(defaultUserConf.getUser().getUserName());
        if (user == null) {
            user = userMapper.save(defaultUserConf.getUser());
            if (user != null) {
                log.error("Insert user ok.user=" + user);
            } else {
                log.error("Insert user error.");
                return;
            }
        } else {
            log.error("User already exist.user=" + user);
        }
        log.error("Default user=" + defaultUserConf.getUser());
        if (user.getId().intValue() != defaultUserConf.getUser().getId()) {
            userMapper.updateUserId(user.getId(), defaultUserConf.getUser().getId());
            log.error("Update user ok.");
        }
    }

}

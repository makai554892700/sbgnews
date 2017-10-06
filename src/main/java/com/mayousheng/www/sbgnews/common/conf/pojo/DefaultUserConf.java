package com.mayousheng.www.sbgnews.common.conf.pojo;

import com.mayousheng.www.sbgnews.pojo.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("defaultUserConf")
@ConfigurationProperties(prefix = "user.default")
public class DefaultUserConf {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "DefaultUserConf{" +
                "user=" + user +
                '}';
    }
}

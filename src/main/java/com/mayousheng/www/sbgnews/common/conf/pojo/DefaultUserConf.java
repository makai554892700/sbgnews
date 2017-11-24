package com.mayousheng.www.sbgnews.common.conf.pojo;

import com.mayousheng.www.sbgnews.pojo.auth.Permission;
import com.mayousheng.www.sbgnews.pojo.auth.Role;
import com.mayousheng.www.sbgnews.pojo.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component("defaultUserConf")
@ConfigurationProperties(prefix = "user.default")
public class DefaultUserConf {

    private User user;
    private Permission permission;
    private Role role;
    private String encrypt;
    private String salt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "DefaultUserConf{" +
                "user=" + user +
                ", permission=" + permission +
                ", role=" + role +
                ", encrypt='" + encrypt + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}

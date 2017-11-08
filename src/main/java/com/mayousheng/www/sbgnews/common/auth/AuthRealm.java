package com.mayousheng.www.sbgnews.common.auth;

import com.mayousheng.www.sbgnews.pojo.Permission;
import com.mayousheng.www.sbgnews.pojo.Role;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    private Logger log = LoggerFactory.getLogger(AuthRealm.class);

    @Resource(name = "userServiceImpl")
    private UserService userService;

    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        User user = userService.getUserByUserName(username);
        return new SimpleAuthenticationInfo(user, user.getPassWord(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user = (User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions = new ArrayList<>();
        List<Role> roles = user.getRoles();
        if (roles != null && roles.size() > 0) {
            for (Role role : roles) {
                List<Permission> permissionList = role.getPermissions();
                if (permissionList != null && permissionList.size() > 0) {
                    for (Permission permission : permissionList) {
                        permissions.add(permission.getPermissionName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }

}
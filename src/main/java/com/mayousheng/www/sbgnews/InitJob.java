package com.mayousheng.www.sbgnews;

import com.mayousheng.www.sbgnews.common.conf.pojo.BSBDJConf;
import com.mayousheng.www.sbgnews.common.conf.pojo.DefaultUserConf;
import com.mayousheng.www.sbgnews.common.conf.pojo.JokeConf;
import com.mayousheng.www.sbgnews.mapper.UserMapper;
import com.mayousheng.www.sbgnews.pojo.Permission;
import com.mayousheng.www.sbgnews.pojo.Role;
import com.mayousheng.www.sbgnews.pojo.User;
import com.mayousheng.www.sbgnews.service.BSBDJService;
import com.mayousheng.www.sbgnews.service.JokeService;
import com.mayousheng.www.sbgnews.service.PermissionService;
import com.mayousheng.www.sbgnews.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitJob {

    private Logger log = LoggerFactory.getLogger(InitJob.class);

    @Resource(name = "defaultUserConf")
    private DefaultUserConf defaultUserConf;
    @Resource(name = "bsbdjConf")
    private BSBDJConf bsbdjConf;
    @Resource(name = "jokeConf")
    private JokeConf jokeConf;
    @Resource(name = "userMapperImpl")
    private UserMapper userMapper;
    @Resource(name = "jokeServiceImpl")
    private JokeService jokeService;
    @Resource(name = "bsbdjServiceImpl")
    private BSBDJService bsbdjService;
    @Resource(name = "permissionServiceImpl")
    private PermissionService permissionService;
    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    @PostConstruct
    public void insetDefaultUser() throws Exception {
        Permission tempPermission = defaultUserConf.getPermission();
        Permission permission = permissionService.getPermissionByPermissionName(tempPermission.getPermissionName());
        if (permission == null) {
            permission = permissionService.save(tempPermission);
        }
        Role tempRole = defaultUserConf.getRole();
        Role role = roleService.getRoleByRoleName(tempRole.getRoleName());
        if (role == null) {
            List<Permission> permissions = new ArrayList<>();
            permissions.add(permission);
            tempRole.setPermissions(permissions);
            role = roleService.save(tempRole);
        }
        User tempUser = defaultUserConf.getUser();
        User user = userMapper.getUserByUserName(tempUser.getUserName());
        if (user == null) {
            if (userMapper.insert(tempUser.getId(), tempUser.getEmail(), tempUser.getImgUrl(), tempUser.getMsg()
                    , tempUser.getNickName(), tempUser.getPageHome(), tempUser.getPassWord(), tempUser.getUserName()
                    , tempUser.getSex(), tempUser.getUserName()) > 0) {
                List<Role> roleList = new ArrayList<>();
                roleList.add(role);
                tempUser.setRoles(roleList);
                userMapper.save(tempUser);
                log.error("Insert user ok");
            } else {
                log.error("Insert user error.");
                return;
            }
        } else {
            log.error("User already exist.");
        }
        if (!jokeConf.getLoaded()) {
            jokeService.loadAllJokes();
        } else {
            jokeService.setLoaded(true);
        }
        if (!bsbdjConf.getLoaded()) {
            bsbdjService.loadAllDatas();
        } else {
            bsbdjService.setLoaded(true);
        }
    }

}

package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.auth.Role;

public interface RoleService {

    public Role getRoleByRoleName(String roleName);

    public Role save(Role role);

}

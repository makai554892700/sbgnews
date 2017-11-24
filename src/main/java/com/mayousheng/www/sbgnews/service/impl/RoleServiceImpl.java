package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.RoleMapper;
import com.mayousheng.www.sbgnews.pojo.auth.Role;
import com.mayousheng.www.sbgnews.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Resource(name = "roleMapperImpl")
    private RoleMapper roleMapper;

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleMapper.getRoleByRoleName(roleName);
    }

    @Override
    public Role save(Role role) {
        return roleMapper.save(role);
    }
}

package com.mayousheng.www.sbgnews.service.impl;

import com.mayousheng.www.sbgnews.mapper.PermissionMapper;
import com.mayousheng.www.sbgnews.pojo.Permission;
import com.mayousheng.www.sbgnews.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("permissionServiceImpl")
public class PermissionServiceImpl implements PermissionService {

    @Resource(name = "permissionMapperImpl")
    private PermissionMapper permissionMapper;

    @Override
    public Permission getPermissionByPermissionName(String permissionName) {
        return permissionMapper.getPermissionByPermissionName(permissionName);
    }

    @Override
    public Permission save(Permission permission) {
        return permissionMapper.save(permission);
    }
}

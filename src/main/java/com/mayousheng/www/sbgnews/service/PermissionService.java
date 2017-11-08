package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.Permission;

public interface PermissionService {

    public Permission getPermissionByPermissionName(String permissionName);

    public Permission save(Permission permission);

}

package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("permissionMapperImpl")
public interface PermissionMapper extends JpaRepository<Permission, Integer> {

    public Permission getPermissionByPermissionName(String permissionName);

}

package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleMapperImpl")
public interface RoleMapper extends JpaRepository<Role, Integer> {

    public Role getRoleByRoleName(String roleName);

}

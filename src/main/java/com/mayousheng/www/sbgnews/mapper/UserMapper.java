package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userMapper")
public interface UserMapper extends JpaRepository<User, Integer> {

    public User getUserByUserName(String userName);

    @Transactional //执行自定义sql更新或者删除时必须带
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update user set id = :newId where id = :oldId")
    public void updateUserId(@Param("oldId") Integer oldId, @Param("newId") Integer newId);

}

package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userMapperImpl")
public interface UserMapper extends JpaRepository<User, Integer> {

    public User getUserByUserName(String userName);

    @Transactional //执行自定义sql更新或者删除时必须带
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "insert into user (id, email, img_url, msg, nick_name, page_home, pass_word, phone, sex, user_name) " +
            "values (:id, :email, :img_url, :msg, :nick_name, :page_home, :pass_word, :phone, :sex, :user_name)")
    public Integer insert(@Param("id") Integer id, @Param("email") String email, @Param("img_url") String imgUrl,
                       @Param("msg") String msg, @Param("nick_name") String nickName
            , @Param("page_home") String pageHome, @Param("pass_word") String passWord
            , @Param("phone") String phone, @Param("sex") Integer sex, @Param("user_name") String userName);

    @Transactional //执行自定义sql更新或者删除时必须带
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true, value = "update user set id = :newId where id = :oldId")
    public void updateUserId(@Param("oldId") Integer oldId, @Param("newId") Integer newId);

}

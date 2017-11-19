package com.mayousheng.www.sbgnews.service;

import com.mayousheng.www.sbgnews.pojo.User;

public interface UserService {

    public User getUserByUserName(String userName);

    public User save(User user);

    public User update(User user, boolean updateRole);

    public void delete(Integer id);

}

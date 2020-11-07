package com.mzx.shiromzx209.dao;

import com.mzx.shiromzx209.entity.User;

/**
 * @author Mzx
 */
public interface UserDao {

    // 根据id查询用户接口
    User findById(Integer id);

    // 根据username查询用户接口
    User findByName(String username);

}

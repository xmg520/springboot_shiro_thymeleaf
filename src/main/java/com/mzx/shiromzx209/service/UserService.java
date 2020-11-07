package com.mzx.shiromzx209.service;

import com.mzx.shiromzx209.entity.User;

/**
 * @author Mzx
 */
public interface UserService {

    User findById(Integer id);

    User findByName(String username);

}

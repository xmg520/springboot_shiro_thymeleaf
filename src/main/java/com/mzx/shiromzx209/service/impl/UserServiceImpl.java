package com.mzx.shiromzx209.service.impl;

import com.mzx.shiromzx209.dao.UserDao;
import com.mzx.shiromzx209.entity.User;
import com.mzx.shiromzx209.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mzx
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}

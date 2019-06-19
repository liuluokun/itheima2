package com.daima.ssm.service.impl;

import com.daima.ssm.dao.UserDao;
import com.daima.ssm.domian.User;
import com.daima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;


    public User checkLogin(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {

            return user;
        }
        return null;

    }

    public List<User> listUser() {

        return userDao.listUser();
    }
}

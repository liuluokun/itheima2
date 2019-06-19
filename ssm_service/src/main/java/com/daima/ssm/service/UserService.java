package com.daima.ssm.service;



import com.daima.ssm.domian.User;

import java.util.List;


public interface UserService {

    User checkLogin(String username, String password);

    List<User> listUser();
}

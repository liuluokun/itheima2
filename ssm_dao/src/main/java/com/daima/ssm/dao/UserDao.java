package com.daima.ssm.dao;

import com.daima.ssm.domian.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserDao {

    @Select("select * from s_user where username=#{username}")
    User findByUsername(String username);

    @Select("select * from s_user")
    List<User> listUser();


    @Select("select * from s_user where uid = #{uid}")
    User findRolesName(Integer uid);
}

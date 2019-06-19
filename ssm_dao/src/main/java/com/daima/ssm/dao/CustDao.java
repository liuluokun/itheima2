package com.daima.ssm.dao;

import com.daima.ssm.domian.Cust;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustDao {

    @Select("SELECT * FROM s_cust c,s_user u where c.cust_link_user = u.uid")
    @Results(id = "userMap",value = {
            @Result(property = "user",column = "cust_link_user",
                    one=@One(select = "com.daima.ssm.dao.UserDao.findRolesName"))
    })
    List<Cust> listCust();

    @Select("select * from s_cust where cust_name like #{custName} and cust_type like #{custType}")
    List<Cust> selectByCondition(@Param("custName") String custName,@Param("custType") String custType);

    @Delete("delete from s_cust where cid=#{cid}")
    void delete(Integer cid);

    @Insert("insert into s_cust values(null,#{cust_name},#{cust_type},#{cust_phone},#{cust_address},#{user.uid})")
    void add(Cust cust);
}

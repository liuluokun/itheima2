package com.daima.ssm.service;

import com.daima.ssm.domian.Cust;

import java.util.List;

public interface CustService {
    List<Cust> listCust();

    List<Cust> selectByCondition(String custName, String custType);

    void delete(Integer cid);

    void add(Cust cust);
}

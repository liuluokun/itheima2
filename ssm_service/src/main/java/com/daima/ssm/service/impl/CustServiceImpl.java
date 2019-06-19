package com.daima.ssm.service.impl;

import com.daima.ssm.dao.CustDao;
import com.daima.ssm.domian.Cust;
import com.daima.ssm.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustServiceImpl implements CustService {

    @Autowired
    CustDao custDao;

    public List<Cust> listCust() {
        return custDao.listCust();
    }

    public List<Cust> selectByCondition(String custName, String custType) {
        custName = "%" + custName + "%";
        custType = "%" + custType + "%";
        List<Cust> custs = custDao.selectByCondition(custName, custType);
        return custs;
    }

    public void delete(Integer cid) {
        custDao.delete(cid);
    }

    public void add(Cust cust) {
        custDao.add(cust);
    }
}

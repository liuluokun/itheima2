package com.daima.ssm.controller;


import com.daima.ssm.domian.Cust;
import com.daima.ssm.domian.User;
import com.daima.ssm.service.CustService;
import com.daima.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {

    @Autowired
    CustService custService;

    @Autowired
    UserService userService;

    @RequestMapping("/listCust")
    public String listCust(Model model) {
        List<Cust> custs = custService.listCust();
      //  System.out.println(custs);
        model.addAttribute("list", custs);
        List<User> users = userService.listUser();
      //  System.out.println(users);
        model.addAttribute("users", users);
        return "center";
    }

    @RequestMapping("selectByCondition")
    public String selectByCondition(@RequestParam(name = "custName", required = false, defaultValue = "") String custName,
                                    @RequestParam(name = "custType", required = false, defaultValue = "") String custType,
                                    Model model) {
        List<Cust> custs = custService.selectByCondition(custName, custType);
        model.addAttribute("list", custs);
        List<User> users = userService.listUser();
        model.addAttribute("users", users);
        return "center";
    }


    @RequestMapping("/delete")
    public String delete(Integer cid){
        custService.delete(cid);
        return "redirect:/cust/listCust";
    }

    @RequestMapping("/add")
    public String add(Cust cust) {
        custService.add(cust);
        System.out.println("执行了添加方法");
        return "redirect:/cust/listCust";
    }

}


package org.example.javaweb_crm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转到登录页面
@Controller
public class MyCRM {
    @RequestMapping("/MyCRM")
    public String Mycrm(){
        return "redirect:/html/login.html";
    }



}


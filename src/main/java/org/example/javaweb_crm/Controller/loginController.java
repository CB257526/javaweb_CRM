package org.example.javaweb_crm.Controller;


import jakarta.servlet.http.HttpSession;
import org.example.javaweb_crm.Service.iml.loginiml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class loginController {
    @Autowired
    private loginiml loginiml;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {

        if (username == null || password == null) {
            return "redirect:/html/login.html";
        }

        boolean b = loginiml.loginIS(username, password);
        if(b){
            session.setAttribute("username", username);
            return "redirect:/html/MainPage.html";
        }else{
            return "redirect:/html/login_failed.html";
        }
    }

    // 添加获取用户信息的方法
    @GetMapping("/api/user/info")
    @ResponseBody
    public Map<String, String> getUserInfo(HttpSession session) {
        Map<String, String> userInfo = new HashMap<>();
        String username = (String) session.getAttribute("username");
        if (username != null) {
            userInfo.put("username", username);
            userInfo.put("role", "管理员"); // 可以根据实际情况从数据库获取角色信息
        } else {
            userInfo.put("username", "未登录");
            userInfo.put("role", "访客");
        }
        return userInfo;
    }
}
package com.qf.j1904.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class UserController {
    @RequestMapping(value = "/mainview")
    public String logindeal(String loginName, String userpwd){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token=new UsernamePasswordToken(loginName,userpwd);
            subject.login(token);
            if(subject.isAuthenticated()){
                System.out.println("login sucessful.....");
                return "main";
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }
}

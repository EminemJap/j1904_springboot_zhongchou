package com.qf.j1904.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/loginview")
    public String loginview(){
        return "login";
    }
    @RequestMapping("/indexview")
    public String index(){
        return "index";
    }
    @RequestMapping("/userview")
    public String userview(){
        return "user";
    }
    @RequestMapping("roleview")
    public String roleview(){
        return "role";
    }
    @RequestMapping("adminview")
    public String adminview(){
        return "admin";
    }
    @RequestMapping("permissionview")
    public String permission(){
        return "permission";
    }
}

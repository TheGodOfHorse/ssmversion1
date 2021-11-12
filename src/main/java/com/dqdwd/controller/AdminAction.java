package com.dqdwd.controller;

import com.dqdwd.pojo.Admin;
import com.dqdwd.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, Model model) {
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            model.addAttribute("admin", admin);
            return "main";
        } else {
            model.addAttribute("errmsg", "用户名或者是密码错误");
            return "login";
        }
    }

    @RequestMapping("/regist")
    public String regist(@RequestParam("myname") String username,@RequestParam("mypwd")String password,Model model) {
        if (!adminService.existAdmin(username)) {
            Admin admin = new Admin();
            admin.setaName(username);
            admin.setaPass(password);
            adminService.addAdmin(admin);
            return "login";
        } else {
            model.addAttribute("errmsg","用户名已存在");
            return "regist";
        }
    }
}

package com.aym.controller;


import com.aym.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/load")
public class LoadTest {

    /*通过HttpServletRequest获取前台的值*/

    @RequestMapping("/test")
    public String test(HttpServletRequest request, Model model){
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        model.addAttribute("user",name);
        if("admin".equals(name) && "admin".equals(password)){
            return "success";
        }
        else{
            return "fail";
        }
    }

    /*通过实体类获取前台的值*/

    @RequestMapping("/test1")
    public String test2(User user, Model model){
        String name = user.getUsername();
        String password = user.getPassword();
        model.addAttribute("user",name);
        if("admin".equals(name) && "admin".equals(password)){
            return "success";
        }
        else{
            return "fail";
        }

    }
}

package com.yu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginCotroller {
    @GetMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        //具体的业务
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        else{
            model.addAttribute("msg", "用户名或者密码错误!");
            return "index";
        }
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "index";
    }
}
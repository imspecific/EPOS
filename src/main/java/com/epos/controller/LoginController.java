package com.epos.controller;

import com.epos.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;


    //= localhost:8082/login
    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");     //= /WEB-INF/views/login.jsp
    }

    @PostMapping(value = "/login")
    public ModelAndView loginPage(@RequestParam("userName") String userName,
                                  @RequestParam("password") String userPassword,
                                  @RequestParam("loginUser") String loginUser, Model model) {
        return loginService.loginPage(userName, userPassword, loginUser, model);
    }

    @GetMapping(value = "/homeePOSAdmin")
    public ModelAndView homeePOSAdminView() {
        return new ModelAndView("homeePOSAdmin");
    }
}

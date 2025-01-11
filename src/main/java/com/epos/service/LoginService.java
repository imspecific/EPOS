package com.epos.service;

import com.epos.exception.UserNotFoundException;
import com.epos.model.User;
import com.epos.repository.LoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Service
public class LoginService {

    @Autowired
    private LoginRepo loginRepo;
    private static final String LOGIN_USER_DOMAIN_ADMIN = "Admin";
    private static final String LOGIN_USER_DOMAIN_EPOS_ADMIN = "EPOS Admin";

    public ModelAndView loginPage(String userName, String userPassword, String loginUser, Model model) {
        try {
            Optional<User> user = loginRepo.findByUserNameAndUserPassword(userName, userPassword);
            if (user.isPresent()) {
                model.addAttribute("userName", user.get().getEName());
                if (loginUser.equals(LOGIN_USER_DOMAIN_ADMIN) && userName.equals("admin")) {
                    log.info("Login Successful for Admin.");
                    return new ModelAndView("adminhome");
                } else if (loginUser.equals(LOGIN_USER_DOMAIN_EPOS_ADMIN) && userName.equals("eposadmin")) {
                    log.info("Login successful for EPOS Admin.");
                    return new ModelAndView("homeePOSAdmin");
                } else {
                    log.info("Enter valid password.");
                }
            } else {
                log.info("Login failed.");
                throw new UserNotFoundException("User not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("login");
    }
}

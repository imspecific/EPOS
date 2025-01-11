package com.epos.controller;

import com.epos.exception.UserNotFoundException;
import com.epos.model.User;
import com.epos.repository.LoginRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
public class LoginController {

	private static final String LOGIN_USER_DOMAIN_ADMIN = "Admin";
	private static final String LOGIN_USER_DOMAIN_EPOS_ADMIN = "EPOS Admin";
	@Autowired
	private LoginRepo loginRepo;

	//= localhost:8082/login
	@GetMapping(value = "/login")
	public ModelAndView loginPage() {
		return new ModelAndView("login");	 //= /WEB-INF/views/login.jsp
	}
	@PostMapping(value="/login")
	public ModelAndView loginHome(@RequestParam("userName") String userName,
								  @RequestParam("password") String userPassword,
								  @RequestParam("loginUser") String loginUser, Model model) {
		//User user = null;
		try {
			Optional<User> user = loginRepo.findByUserNameAndUserPassword(userName,userPassword);
			if (user.isPresent()) {
				model.addAttribute("userName", user.get().getEName());
				if(loginUser.equals(LOGIN_USER_DOMAIN_ADMIN) && userName.equals("admin")) {
					log.info("Login Successful for Admin.");
					return new ModelAndView("adminhome");
				} else if(loginUser.equals(LOGIN_USER_DOMAIN_EPOS_ADMIN) && userName.equals("eposadmin")) {
					log.info("Login successful for EPOS Admin.");
					return new ModelAndView("homeePOSAdmin");
				} else {
					log.info("Enter valid password.");
				}
			}
			else {
				log.info("Login failed.");
				throw new UserNotFoundException("User not found.");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("login");
	}

	@GetMapping(value = "/homeePOSAdmin")
	public ModelAndView homeePOSAdminView() { 	
		return new ModelAndView("homeePOSAdmin");   
	}
}

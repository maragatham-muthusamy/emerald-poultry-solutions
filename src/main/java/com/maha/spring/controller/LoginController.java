package com.maha.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.maha.spring.entity.User;
import com.maha.spring.service.UserRepository;

@Controller
public class LoginController {

	@Autowired
	private UserRepository userRepo;
	
	@GetMapping(value = "/login")
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String loginsubmit(Locale locale, Model model) {
		return "redirect:user/list";
	}

	@GetMapping(value = "/signup")
	public String signup(@Validated UserForm user, Model model) {
		// model.addAttribute("userName", user.getUserName());
		return "signup";
	}

	@PostMapping(value = "/signup_submit")
	public String signuppost(@ModelAttribute("userForm")UserForm userform, Model model) {
		User oneuser = new User();
		
		oneuser.setFirstName(userform.getFirstName());
		oneuser.setLastName(userform.getLastName());
		oneuser.setEmail(userform.getEmail());
		oneuser.setPhone(userform.getPhone());
		oneuser.setUsername(userform.getUsername());
		oneuser.setPassword(userform.getPassword());

		userRepo.save(oneuser);
		
		// model.addAttribute("userName", user.getUserName());
		return "home";
	}
}

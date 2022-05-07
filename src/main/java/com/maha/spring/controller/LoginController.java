package com.maha.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping(value = "/signup")
	public String signuppost(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userRepo.save(user);
		
		// model.addAttribute("userName", user.getUserName());
		return "home";
	}
}

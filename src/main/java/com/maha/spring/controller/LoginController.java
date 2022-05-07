package com.maha.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.maha.spring.entity.User;
import com.maha.spring.service.UserRepository;

@Controller
public class LoginController {
	
	@GetMapping(value = "/login")
	public String login(Model model) {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String loginsubmit(Model model) {
		return "redirect:user/list";
	}
}

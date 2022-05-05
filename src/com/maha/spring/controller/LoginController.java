package com.maha.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maha.spring.entity.Users;
import com.maha.spring.security.UserRepository;
import com.maha.spring.service.UsersService;

@Controller
public class LoginController {

//    @Autowired
    private UserRepository userRepo;
     
    // @Autowired
	// private UsersService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginsubmit(Locale locale, Model model) {
		return "redirect:user/list";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@Validated User user, Model model) {
		// model.addAttribute("userName", user.getUserName());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signuppost(@ModelAttribute("userForm")User userform, Model model) {
		Users oneuser = new Users();

		oneuser.setFirstName(userform.getFirstName());
		oneuser.setLastName(userform.getLastName());
		oneuser.setEmail(userform.getEmail());
		oneuser.setPhone(userform.getPhone());
		oneuser.setUsername(userform.getUsername());
		oneuser.setPassword(userform.getPassword());

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(oneuser.getPassword());
		
		oneuser.setPassword(encodedPassword);

		userRepo.save(oneuser);
		//userService.saveUser(oneuser);
		
		// model.addAttribute("userName", user.getUserName());
		return "home";
	}
}

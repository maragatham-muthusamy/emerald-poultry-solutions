package com.maha.spring;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.maha.spring.entity.Users;
import com.maha.spring.service.UsersService;
import com.maha.spring.service.UsersServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UsersService userService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Locale locale, Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String home(@Validated User user, Model model) {
		model.addAttribute("userName", user.getFirstName());
		return "home";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@Validated User user, Model model) {
		// model.addAttribute("userName", user.getUserName());
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signuppost(@Validated User user, @ModelAttribute("userForm")User userform, Model model) {
		Users oneuser = new Users();
		
		oneuser.setFirstName(userform.getFirstName());
		oneuser.setLastName(userform.getLastName());
		oneuser.setEmail(userform.getEmail());
		oneuser.setPassword(userform.getPassword());

		userService.saveUser(oneuser);
		
		// model.addAttribute("userName", user.getUserName());
		return "home";
	}
}

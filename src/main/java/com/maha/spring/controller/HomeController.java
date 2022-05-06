package com.maha.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@GetMapping(value = {"/home", "/"})
	public String home(Model model) {
		return "home";
	}
}

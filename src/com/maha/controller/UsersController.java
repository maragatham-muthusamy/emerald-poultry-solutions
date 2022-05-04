package com.maha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maha.spring.entity.Users;
import com.maha.spring.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {

	// need to inject our user service
	@Autowired
	private UsersService userService;
	
	@GetMapping("/list")
	public String list(Model theModel) {
		
		// get users from the service
		List<Users> theUsers = userService.getUsers();

		// add the users to the model
		theModel.addAttribute("users", theUsers);
		
		return "list-users";
	}

	@GetMapping("/add")
	public String add(Model theModel) {
		
		// create model attribute to bind form data
		Users theUser = new Users();
		
		theModel.addAttribute("addupd", theUser);
		theModel.addAttribute("adding", true);
		
		// page is common for add and update, but this handler is only for add
		return "addupduser";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("addupd") Users theUser) {

		// save the user using our service
		userService.saveUser(theUser);
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("userId") int theId, Model theModel) {

		// get the user from our service
		Users theUser = userService.getUser(theId);	

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("addupd", theUser);
		theModel.addAttribute("adding", false);

		// page is common for add and update, but this handler is only for update
		return "addupduser";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("userId") int theId) {
		
		// delete the user
		userService.deleteUser(theId);
		return "redirect:/user/list";
	}
}

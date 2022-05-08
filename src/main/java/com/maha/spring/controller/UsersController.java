package com.maha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maha.spring.entity.User;
import com.maha.spring.service.UserRepository;

@Controller
@RequestMapping("/user")
public class UsersController {

	// need to inject our user service
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/list")
	public String list(Model theModel) {
		
		// get users from the service
		List<User> theUsers = userRepo.findAll();

		// add the users to the model
		theModel.addAttribute("users", theUsers);
		
		return "listusers";
	}

	@GetMapping("/add")
	public String add(Model theModel) {
		
		// create model attribute to bind form data
		User theUser = new User();
		
		theModel.addAttribute("addupd", theUser);
		theModel.addAttribute("adding", true);
		
		// page is common for add and update, but this handler is only for add
		return "addupduser";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("addupd") User theUser) {

		// save the user using our service
		userRepo.save(theUser);
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("userId") Long theId, Model theModel) {

		// get the user from our service
		User theUser = userRepo.findById(theId).orElse(new User());

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("addupd", theUser);
		theModel.addAttribute("adding", false);

		// page is common for add and update, but this handler is only for update
		return "addupduser";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("userId") Long theId) {
		
		// delete the user
		userRepo.deleteById(theId);
		return "redirect:/user/list";
	}
}

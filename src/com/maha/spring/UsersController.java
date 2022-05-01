package com.maha.spring;

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
import com.maha.spring.entity.Production;
import com.maha.spring.service.ProductionService;
import com.maha.spring.service.UsersService;

@Controller
@RequestMapping("/user")
public class UsersController {

	// need to inject our user service
	@Autowired
	private UsersService userService;

	@Autowired
	private ProductionService productionService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		// get users from the service
		List<Users> theUsers = userService.getUsers();
		List<Production> productions = productionService.getProductions();

		// add the users to the model
		theModel.addAttribute("users", theUsers);
		theModel.addAttribute("users1", productions);
		
		return "list-users";
	}

	@GetMapping("/adduser")
	public String adduser(Model theModel) {
		
		// create model attribute to bind form data
		Users theUser = new Users();
		
		theModel.addAttribute("useraddupd", theUser);
		theModel.addAttribute("adding", true);
		
		// page is common for add and update, but this handler is only for add
		return "addupduser";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("useraddupd") Users theUser) {
		
		// save the user using our service
		userService.saveUser(theUser);	
		
		return "redirect:/user/list";
	}
	
	@GetMapping("/updateuser")
	public String updateuser(@RequestParam("userId") int theId, Model theModel) {

		// get the user from our service
		Users theUser = userService.getUser(theId);	
		
		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("useraddupd", theUser);
		theModel.addAttribute("adding", false);
		
		// send over to our form		
		return "addupduser";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		// delete the user
		userService.deleteUser(theId);
		return "redirect:/user/list";
	}
}
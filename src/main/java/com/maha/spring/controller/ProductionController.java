package com.maha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maha.spring.entity.Production;
import com.maha.spring.security.EepsUserDetails;
import com.maha.spring.service.ProductionRepository;

@Controller
@RequestMapping("/production")
public class ProductionController {

	// need to inject our production service
	@Autowired
	private ProductionRepository productionRepo;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof EepsUserDetails) {
			Long id = ((EepsUserDetails)principal).getId();

			// get users from the service
		  	List<Production> productions = productionRepo.findAllById(id);

			// add the users to the model
			theModel.addAttribute("productions", productions);
			return "listproduction";
		}
		
		// generally shouldn't happen
		return "home";
	}
	
	@GetMapping("/add")
	public String add(Model theModel) {
		
		// create model attribute to bind form data
		Production production = new Production();

		theModel.addAttribute("addupd", production);

		return "addupdproduction";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("addupd") Production production) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof EepsUserDetails) {
		  Long id = ((EepsUserDetails)principal).getId();
			// save the record using our service
			production.setUserId(id);
			productionRepo.save(production);
			
			return "redirect:/production/list";
		}

		// this shouldn't happen normally
		return "/";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("prodId") Long theId, Model theModel) {
		// get the user from our service
		Production production = productionRepo.findById(theId).orElse(new Production());

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("addupd", production);
		theModel.addAttribute("adding", false);

		// send over to our form		
		return "addupdproduction";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("prodId") Long theId) {
		
		// delete the user
		productionRepo.deleteById(theId);
		return "redirect:/production/list";
	}
}


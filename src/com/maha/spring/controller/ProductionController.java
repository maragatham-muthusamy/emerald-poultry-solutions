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

import com.maha.spring.entity.Production;
import com.maha.spring.service.ProductionService;

@Controller
@RequestMapping("/production")
public class ProductionController {

	// need to inject our production service
	@Autowired
	private ProductionService productionService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {

		// get users from the service
		List<Production> productions = productionService.getProductions();

		// add the users to the model
		theModel.addAttribute("productions", productions);
		
		return "list-production";
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

		// save the user using our service
		production.setUserId(1);
		productionService.saveProduction(production);	

		return "redirect:/production/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("prodid") int theId, Model theModel) {
		// get the user from our service
		Production production = productionService.getProduction(theId);

		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("addupd", production);
		theModel.addAttribute("adding", false);

		// send over to our form		
		return "addupdproduction";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("prodId") int theId) {
		
		// delete the user
		productionService.deleteProduction(theId);
		return "redirect:/production/list";
	}
}


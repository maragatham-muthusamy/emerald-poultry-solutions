package com.maha.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maha.spring.entity.ContactUs;
import com.maha.spring.service.ContactusRepository;

@Controller
public class ContactUsController {

	@Autowired
	public ContactusRepository contactusRepo;
	
    @GetMapping(value = "/contactus")
    public String contactus(ModelMap modelMap){
    	// send an empty on back to the form
    	modelMap.addAttribute("contactus", new ContactUs());
        return "contactus";
    }

    @PostMapping(value = "/contactus")
    public String contactUsSubmit(@ModelAttribute("contactus") ContactUs contactus, ModelMap modelMap) {
    	// send an empty on back to the form
    	modelMap.addAttribute("contactus", new ContactUs());
    	
    	// save the data now
    	contactusRepo.save(contactus);
        modelMap.addAttribute("result", "Your message has been received. Thank you!");
        return "contactus";
    }
    
    @GetMapping(value = "/contactus/list")
    public String listContactUs(ModelMap modelMap) {
    	List<ContactUs> contactuslist = contactusRepo.findAll();
    	
    	modelMap.addAttribute("contactuslist", contactuslist);
    	
    	return "listcontactus";
    }

	@GetMapping("/contactus/delete")
	public String delete(@RequestParam("id") Long theId) {
		
		// delete the user
		contactusRepo.deleteById(theId);
		return "redirect:/contactus/list";
	}
}

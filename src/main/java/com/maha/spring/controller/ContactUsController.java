package com.maha.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.maha.spring.entity.ContactUs;
import com.maha.spring.service.ContactusRepository;

@Controller
public class ContactUsController {

	@Autowired
	public ContactusRepository contactusRepo;
	
    @GetMapping(value = "/contactus")
    public String printHelloWorld(ModelMap modelMap){
    	// send an empty on back to the form
    	modelMap.addAttribute("contactus", new ContactUs());
        return "contactus";
    }

    @PostMapping(value = "/contactus")
    public String handlePostRequest(@ModelAttribute("contactus") ContactUs contactus, ModelMap modelMap) {
    	// send an empty on back to the form
    	modelMap.addAttribute("contactus", new ContactUs());
    	
    	// save the data now
    	contactusRepo.save(contactus);
        modelMap.addAttribute("result", "Your message has been received. Thank you!");
        return "contactus";
    }
}

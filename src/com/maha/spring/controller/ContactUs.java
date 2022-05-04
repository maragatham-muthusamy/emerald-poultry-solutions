package com.maha.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactUs {

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){
        ContactUSForm contactusform = new ContactUSForm();
        modelMap.put("contactusform", contactusform);
        // return the name of the file to be loaded "home.jsp"
        return "contactus";
    }

    @RequestMapping(value = "/contactus", method = RequestMethod.POST)
    public String handlePostRequest(@ModelAttribute("contactusform") ContactUSForm contactusform, ModelMap modelMap) {
    	// TODO: create DAO / hibernate classes and post these values to database
        //modelMap.put("contactusform", contactusform);
        modelMap.addAttribute("result", "Your message has been received. Thank you!");
        return "contactus";
    }
}

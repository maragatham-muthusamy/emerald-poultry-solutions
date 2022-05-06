package com.maha.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutUs {

    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){

        // return the name of the file to be loaded "home.jsp"
        return "aboutus";
    }
}

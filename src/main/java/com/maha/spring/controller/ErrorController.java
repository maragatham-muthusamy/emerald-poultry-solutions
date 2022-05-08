package com.maha.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping(value = "/error")
    public String printHelloWorld(ModelMap modelMap){

        return "error";
    }
}

package com.hjl.controller;

import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.RequestMapping;
 

@Controller
public class TestController {
 
	@RequestMapping(value="/")
    public String test( ) {
        return "user"; 
    }
	
	@RequestMapping(value="/login")
    public String login() {
        return "login"; 
    }
}

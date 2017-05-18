package com.test.dangyel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	
	
	@RequestMapping("/home")
	public String Main(){
		
	String url="home";
	
	return url;
		
		
	}
	
	
}

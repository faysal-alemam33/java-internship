package com.amigoscode.springdatajpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("/")
	public String home() {
		System.out.println("home page is requested ----------");
		return "home.jsp";
	}
	
}

package com.spring.myFirstApp;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer{

	public void compile() {
		System.out.println("Laptop Compiling with 404 bugs");
	}
	
}

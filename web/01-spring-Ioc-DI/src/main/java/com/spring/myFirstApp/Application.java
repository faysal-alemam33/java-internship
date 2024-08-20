package com.spring.myFirstApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		
		
		ApplicationContext context  = SpringApplication.run(Application.class, args);
		
		
		Dev obj1 = context.getBean(Dev.class);
				
//	 this is created in JVM only but not on IoC Container
//		Dev obj = new Dev();
//		obj.build(); 
		
		
	}

}

package com.amigoscode.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amigoscode.springdatajpa.Repository.ProductRepository;
import com.amigoscode.springdatajpa.entity.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository) {
		return args -> {
			Product iph11 = new Product("iphone 11","Apple", "Mobile", 20000);
			productRepository.save(iph11);
		};
	}
}


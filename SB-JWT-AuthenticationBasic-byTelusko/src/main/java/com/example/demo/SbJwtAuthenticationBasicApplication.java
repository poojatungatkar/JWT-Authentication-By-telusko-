package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbJwtAuthenticationBasicApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(SbJwtAuthenticationBasicApplication.class, args);
		System.out.println("welcome to jwt authentication...");
	}

}

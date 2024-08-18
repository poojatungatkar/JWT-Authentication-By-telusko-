package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/home")
public class NormalController 
{
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public List<User> normalUser()
	{
		
		return service.allUser();
	}
	
}

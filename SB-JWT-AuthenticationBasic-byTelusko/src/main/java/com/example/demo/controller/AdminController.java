package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private UserService service;
	
	@GetMapping("/all")
	public List<User> allUser()
	{
		return service.allUser();
	}
	
	@PostMapping("/add")
	public String adduser( @RequestBody User user)
	{
		return service.addUser(user);
	}
	
	@GetMapping("{username}")
	public User getSingleUser(@PathVariable("username") String username)
	{
		return service.findUserByName(username);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody User user)
	{
		return service.verify(user);
		
	}
}

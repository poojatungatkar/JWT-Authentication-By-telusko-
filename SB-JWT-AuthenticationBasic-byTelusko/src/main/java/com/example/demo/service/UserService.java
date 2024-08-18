package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService 
{
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JWTService jwtService;
	
	public String addUser(User user)
	{
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "user added to system..!";
	}
	
	public List<User> allUser()
	{
		return repo.findAll();
	}
	
	public User findUserByName(String userName)
	{
		return repo.findByUserName(userName);
	}

	public String verify(User user)
	{
		Authentication authentication= authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
		if(authentication.isAuthenticated())
		{
			return jwtService.generateToken(user.getUserName());
		}
		else
		{
			return "fail...";
		}
		
	}
}

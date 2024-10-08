package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;


public class CustomUserDetails implements UserDetails
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	
	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		HashSet<SimpleGrantedAuthority> set=new HashSet<>();
		
		set.add(new SimpleGrantedAuthority(user.getRole()));
		return set;				
	}

	@Override
	public String getPassword() 
	{
		return user.getPassword();
	}

	@Override
	public String getUsername() 
	{
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked() 
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() 
	{
		return true;
	}

	@Override
	public boolean isEnabled() 
	{
		return true;
	}
	
}

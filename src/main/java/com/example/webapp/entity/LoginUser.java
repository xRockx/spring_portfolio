package com.example.webapp.entity;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {
	
	private Integer id;
	
	public LoginUser(Integer id, String username, @Nullable String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

}

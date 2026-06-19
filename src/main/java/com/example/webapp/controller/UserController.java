package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	/**	DI */
	private final UserService userservice;
	
	@GetMapping("/create")
	public String showUser() {
		return "user/create";
	}
}

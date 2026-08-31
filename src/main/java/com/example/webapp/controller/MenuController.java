package com.example.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.User;
import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MenuController {
	
	private final UserService userservice;
	
	@GetMapping
	public String showMenu(Authentication authentication,Model model) {
		//templatesフォルダ配下のmenu.htmlに遷移
		
		User user = userservice.findByUsername(authentication.getName());
		model.addAttribute("user", user);
		
		return "menu";
	}
}

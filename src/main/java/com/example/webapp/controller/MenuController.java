package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MenuController {
	
	@GetMapping
	public String showMenu() {
		//templatesフォルダ配下のmenu.htmlに遷移
		
		return "menu";
	}
}

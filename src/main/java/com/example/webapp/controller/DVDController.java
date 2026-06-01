package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.entity.User;
import com.example.webapp.service.DVDService;
import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/dvds")
@RequiredArgsConstructor
public class DVDController {
	
	/**	DI */
	private final DVDService dvdservice;
	private final UserService userservice;
	
	@GetMapping("/rental/{id}")
	public String showRental(@PathVariable Integer id, Model model) {
		User user = userservice.findByIdUser(id);
		model.addAttribute("user", user);
		return "dvd/rental";
	}
}

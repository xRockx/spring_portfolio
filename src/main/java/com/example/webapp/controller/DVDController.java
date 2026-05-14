package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.webapp.service.DVDService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/dvds")
@RequiredArgsConstructor
public class DVDController {
	
	/**	DI */
	private final DVDService dvdservice;
	
	
}

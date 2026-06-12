package com.example.webapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.DVD;
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
		List<DVD> dvdList = dvdservice.findRentalAllDVD();
		model.addAttribute("user", user);
		model.addAttribute("dvdList", dvdList);
		return "dvd/rental";
	}

	@PostMapping("/rental/{id}")
	public String entryRental(@PathVariable Integer id, @RequestParam(required = false)
	List<Integer> dvdIds, RedirectAttributes redirectAttributes) {
		if(dvdIds == null || dvdIds.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","DVDを選択してください。");
		}
		else {
			
		}
		
		return "redirect:/dvds/rental/" + id;
	}
}

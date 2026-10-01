package com.example.webapp.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.DVD;
import com.example.webapp.entity.LoginUser;
import com.example.webapp.service.DVDService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/dvds")
@RequiredArgsConstructor
public class DVDController {

	/**	DI */
	private final DVDService dvdservice;

	@GetMapping("/rental")
	public String showRental(Model model) {
		List<DVD> dvdList = dvdservice.findRentalAllDVD();
		model.addAttribute("dvdList", dvdList);
		return "dvd/rental";
	}

	@PostMapping("/rental")
	public String entryRental(Authentication authentication, @RequestParam(required = false)
	List<Integer> dvdIds, RedirectAttributes redirectAttributes) {
		LoginUser loginuser = (LoginUser)authentication.getPrincipal();
		Integer id = loginuser.getId();
		
		if(dvdIds == null || dvdIds.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","DVDを選択してください。");
		}
		else {
			int count = dvdservice.rentalDVD(id, dvdIds);
			if(count > 0) {
				redirectAttributes.addFlashAttribute("message",count + "枚のレンタルが完了しました。");
			} else {
				redirectAttributes.addFlashAttribute("message","レンタルできませんでした。");
			}
			
		}
		
		return "redirect:/dvds/rental";
	}
	
	@GetMapping("/return")
	public String showReturn(Authentication authentication, Model model) {
		LoginUser loginuser = (LoginUser)authentication.getPrincipal();
		Integer id = loginuser.getId();
		
		List<DVD> dvdList = dvdservice.findReturnAllDVD(id);
		model.addAttribute("dvdList", dvdList);
		
		return "dvd/return";
	}
	
	@PostMapping("/return")
	public String entryReturn(@RequestParam(required = false)	List<Integer> dvdIds,
			Authentication authentication,
			RedirectAttributes redirectAttributes) {
		LoginUser loginuser = (LoginUser)authentication.getPrincipal();
		Integer id = loginuser.getId();
		
		if(dvdIds == null || dvdIds.isEmpty()) {
			redirectAttributes.addFlashAttribute("message","DVDを選択してください。");
		}
		else {
			dvdservice.returnofDVD(id, dvdIds);
			redirectAttributes.addFlashAttribute("message","返却が完了しました。");
		}
		
		return "redirect:/dvds/return";
	}
}

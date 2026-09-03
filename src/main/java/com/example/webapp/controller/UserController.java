package com.example.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.LoginUser;
import com.example.webapp.entity.Role;
import com.example.webapp.entity.User;
import com.example.webapp.service.DVDService;
import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	/**	DI */
	private final UserService userservice;
	private final DVDService dvdservice;

	@GetMapping("/create")
	public String showUser() {
		return "user/create";
	}

	@PostMapping("/create")
	public String createUser(@RequestParam(required = false) String name,
			@RequestParam(required = false) String pass,
			@RequestParam(required = false) Role authority,
			RedirectAttributes redirectAttributes) {
		
		if(name == null || name.isBlank()) {
			redirectAttributes.addFlashAttribute("message","名前を入力してください。");
		}
		else if(pass == null || pass.isBlank()) {
			redirectAttributes.addFlashAttribute("message","パスワードを入力してください。");
		}
		else {
			User user = new User(null,name,pass,authority);
			userservice.insertUser(user);
			redirectAttributes.addFlashAttribute("message","ユーザーを登録しました。");
		}
		return "redirect:/users/create";
	}
	
	@GetMapping("/delete")
	public String showUserDelete(Model model) {
		model.addAttribute("deleteUser", new User());
		return "user/delete";
	}
	
	@PostMapping("/delete/search")
	public String searchDeleteUser(Authentication authentication,
			@RequestParam(required = false) Integer No,
			@RequestParam(required = false) String name,
			Model model) {
		
		User user = null;
		LoginUser loginuser = (LoginUser)authentication.getPrincipal();
		Integer id = loginuser.getId();
		
		if(No == null && (name == null || name.isBlank())) {
			model.addAttribute("message", "Noまたは名前を入力してください。");
			return "user/delete";
		}
		
		if(No != null) {
			user = userservice.findByIdUser(No);
		} else {
			user = userservice.findByUsername(name);
			if(user != null) {
				No = user.getId();
			}
		}
		
		if(user == null) {
			model.addAttribute("message", "該当するユーザーが見つかりません。");
			model.addAttribute("deleteUser", new User());
			return "user/delete";
		}else if(No == 1 || No.equals(id)) {
			model.addAttribute("message", "削除できないユーザーです。");
			model.addAttribute("deleteUser", new User());
			return "user/delete";
		}else if(!dvdservice.findReturnAllDVD(No).isEmpty()) {
			model.addAttribute("message", "DVDをレンタルしているユーザーです。");
			model.addAttribute("deleteUser", new User());
			return "user/delete";
		}
		else {
			model.addAttribute("deleteUser", user);
		}
		
		return "user/delete";
	}
	
	@PostMapping("/delete")
	public String deleteUser(Authentication authentication,
			@RequestParam(required = false) Integer No,
			RedirectAttributes redirectAttributes) {
		
		LoginUser loginuser = (LoginUser)authentication.getPrincipal();
		Integer id = loginuser.getId();
		
		if(No == 1 || No.equals(id) || !dvdservice.findReturnAllDVD(No).isEmpty()) {
			redirectAttributes.addFlashAttribute("message","削除できないユーザーです。");
		} else {
			userservice.deleteUser(No);
			redirectAttributes.addFlashAttribute("message","ユーザーを削除しました。");
		}
		return "redirect:/users/delete";
		
	}
	
}

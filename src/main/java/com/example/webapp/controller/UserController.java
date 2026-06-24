package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.webapp.entity.Role;
import com.example.webapp.entity.User;
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

	@PostMapping("/create")
	public String createUser(@RequestParam(required = false) String name,
			@RequestParam(required = false) String pass,
			@RequestParam(required = false) Role authority,
			RedirectAttributes redirectAttributes) {
		
		if(name == null || name.isBlank()) {
			redirectAttributes.addFlashAttribute("message","氏名を入力してください。");
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
	public String showUserDelete() {
		return "user/delete";
	}
	
}

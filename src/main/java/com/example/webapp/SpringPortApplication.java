package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.webapp.entity.DVD;
import com.example.webapp.entity.Role;
import com.example.webapp.entity.User;
import com.example.webapp.service.DVDService;
import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPortApplication.class, args)
		.getBean(SpringPortApplication.class).exe();
	}
	
	private final DVDService dvdservice;
	private final UserService userservice;
	
	private void exe() {
		System.out.println("==== レンタル可能DVD一覧の取得 ===");
		for(DVD d : dvdservice.findRentalAllDVD()) {
			System.out.println(d);
		}
		System.out.println("==== ユーザーの返却可能DVD一覧の取得 ===");
		for(DVD d : dvdservice.findReturnAllDVD(1)) {
			System.out.println(d);
		}
		DVD dvd1 = new DVD(3,"テストDVD3","アニメ",14,null);
		dvdservice.insertDVD(dvd1);
		System.out.println("==== 登録確認 ===");
		System.out.println(3);
		DVD target = dvdservice.findReturnAllDVD(1).get(0);
		target.setUserId(null);
		dvdservice.updateDVD(target);
		System.out.println("==== 更新確認 ===");
		for(DVD d : dvdservice.findRentalAllDVD()) {
			System.out.println(d);
		}
		
		System.out.println("==== 単体取得ID ===");
		System.out.println(userservice.findByIdUser(1));
		System.out.println("==== 単体取得名前 ===");
		System.out.println(userservice.findByUsername("user"));
		System.out.println("==== ユーザー追加 ===");
		User user = new User(3,"ユーザー","pass", Role.USER);
		userservice.insertUser(user);
		System.out.println("==== 追加確認 ===");
		System.out.println(userservice.findByIdUser(2));
		System.out.println("==== 削除確認 ===");
		userservice.deleteUser(3);
		
	}

}

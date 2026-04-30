package com.example.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.webapp.entity.DVD;
import com.example.webapp.entity.Role;
import com.example.webapp.entity.User;
import com.example.webapp.repository.DVDMapper;
import com.example.webapp.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringPortApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPortApplication.class, args)
		.getBean(SpringPortApplication.class).exe();
	}
	
	private final DVDMapper dvdmapper;
	private final UserMapper usermapper;
	
	private void exe() {
		System.out.println("==== レンタル可能DVD一覧の取得 ===");
		for(DVD d : dvdmapper.selectRentalAll()) {
			System.out.println(d);
		}
		System.out.println("==== ユーザーの返却可能DVD一覧の取得 ===");
		for(DVD d : dvdmapper.selectReturnAll(1)) {
			System.out.println(d);
		}
		DVD dvd1 = new DVD(3,"テストDVD3","アニメ",14,null);
		dvdmapper.insert(dvd1);
		System.out.println("==== 登録確認 ===");
		System.out.println(3);
		DVD target = dvdmapper.selectReturnAll(1).get(0);
		target.setUserId(null);
		dvdmapper.update(target);
		System.out.println("==== 更新確認 ===");
		for(DVD d : dvdmapper.selectRentalAll()) {
			System.out.println(d);
		}
		
		System.out.println("==== 単体取得 ===");
		System.out.println(usermapper.selectById(1));
		System.out.println("==== ユーザー追加 ===");
		User user = new User(2,"ユーザー","pass", Role.USER);
		usermapper.insert(user);
		System.out.println("==== 追加確認 ===");
		System.out.println(usermapper.selectById(2));
		usermapper.delete(2);
	}

}

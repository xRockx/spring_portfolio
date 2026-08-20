package com.example.webapp.service.impl;

import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.LoginUser;
import com.example.webapp.entity.User;
import com.example.webapp.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsServiceImpl implements UserDetailsService {
	/** DI */
	private final UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 // 「ユーザーテーブル」からデータを取得
		User user = userMapper.selectByUsername(username);
        if (user != null) {
            // 対象データが存在する
            // UserDetailsの実装クラスを返す
            return new LoginUser(user.getUsername(),
                                 user.getPassword(),
                                 Collections.emptyList());
        } else {
            // 対象データが存在しない
            throw new UsernameNotFoundException(
              username + " => 指定しているユーザー名は存在しません");
        }
	}

}

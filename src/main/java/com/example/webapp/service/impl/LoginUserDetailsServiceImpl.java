package com.example.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webapp.entity.LoginUser;
import com.example.webapp.entity.Role;
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
			return new LoginUser(user.getId(),
					user.getUsername(),
					user.getPassword(),
					getAuthorityList(user.getAuthority()));
		} else {
			// 対象データが存在しない
			throw new UsernameNotFoundException(
					username + " => 指定しているユーザー名は存在しません");
		}
	}

	/**
	 * 権限情報をリストで取得する
	 */
	private List<GrantedAuthority> getAuthorityList(Role role) {
		// 権限リスト
		List<GrantedAuthority> authorities = new ArrayList<>();
		// 列挙型からロールを取得
		authorities.add(new SimpleGrantedAuthority(role.name()));
		// ADMIN ロールの場合、USERの権限も付与
		if (role == Role.ADMIN) {
			authorities.add(
					new SimpleGrantedAuthority(Role.USER.toString()));
		}
		return authorities;
	}

}

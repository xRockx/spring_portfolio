package com.example.webapp.entity;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUser extends User {

	public LoginUser(String username, @Nullable String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public LoginUser(String username, @Nullable String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO 自動生成されたコンストラクター・スタブ
	}

}

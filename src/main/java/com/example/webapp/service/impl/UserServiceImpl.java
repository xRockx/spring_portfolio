package com.example.webapp.service.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.User;
import com.example.webapp.repository.UserMapper;
import com.example.webapp.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	/**	DI */
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public User findByIdUser(Integer id) {
		return userMapper.selectById(id);
	}

	@Override
	public User findByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

	@Override
	public void insertUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userMapper.insert(user);
	}

	@Override
	public void deleteUser(Integer id) {
		userMapper.delete(id);
	}

}

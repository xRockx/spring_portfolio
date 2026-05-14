package com.example.webapp.service;

import com.example.webapp.entity.User;

public interface UserService {
	/**
	 * レンタル可能DVD一覧の取得
	 */
	User findByIdUser(Integer id);
	
	/**
	 * ユーザー名検索（ログイン用仮）
	 */
	User findByUsername(String username);
	
	/**
	 * ユーザー追加
	 */
	void insertUser(User user);
	
	/**
	 * ユーザー削除
	 */
	void deleteUser(Integer id);
}

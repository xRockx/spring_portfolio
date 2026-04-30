package com.example.webapp.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.User;

@Mapper
public interface UserMapper {
	/**
	 * 単体取得
	 */
	User selectById(Integer id);
	
	/**
	 * ユーザー名検索（ログイン用仮）
	 */
	User selectByUsername(String username);
	
	/**
	 * ユーザー追加
	 */
	void insert(User user);
	
	/**
	 * ユーザー削除
	 */
	void delete(Integer id);
}

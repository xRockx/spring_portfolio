package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.DVD;

@Mapper
public interface DVDMapper {
	/**
	 * レンタル可能DVD一覧の取得
	 */
	List<DVD> selectRentalAll();
	
	/**
	 * ユーザーの返却可能DVD一覧の取得
	 */
	List<DVD> selectReturnAll(Integer id);
	
	/**
	 * DVDの追加
	 */
	void insert(DVD dvd);
	
	/**
	 * DVDの更新（レンタルユーザーの削除など）
	 */
	void update(DVD dvd);
	
}

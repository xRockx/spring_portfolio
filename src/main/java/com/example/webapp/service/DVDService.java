package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.DVD;

public interface DVDService {
	/**
	 * レンタル可能DVD一覧の取得
	 */
	List<DVD> findRentalAllDVD();
	
	/**
	 * ユーザーの返却可能DVD一覧の取得
	 */
	List<DVD> findReturnAllDVD(Integer id);
	
	/**
	 * DVDの追加
	 */
	void insertDVD(DVD dvd);
	
	/**
	 * DVDレンタル（レンタルユーザーの追加）
	 */
	int rentalDVD(Integer userId, List<Integer> dvdIds);
	
	/**
	 * DVDの更新（レンタルユーザーの削除など）
	 */
	void returnofDVD(Integer userId, List<Integer> dvdIds);
	
}

package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.webapp.entity.DVD;

@Mapper
public interface DVDMapper {
	/**
	 * 全DVDの取得
	 */
	List<DVD> selectAll();
	
	
	/**
	 * 単体の取得
	 */
	DVD selectById();
	
}

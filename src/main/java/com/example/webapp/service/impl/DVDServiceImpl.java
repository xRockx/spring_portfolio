package com.example.webapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.webapp.entity.DVD;
import com.example.webapp.repository.DVDMapper;
import com.example.webapp.service.DVDService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DVDServiceImpl implements DVDService {

	/**	DI */
	private final DVDMapper dvdMapper;
	
	@Override
	public List<DVD> findRentalAllDVD() {
		return dvdMapper.selectRentalAll();
	}

	@Override
	public List<DVD> findReturnAllDVD(Integer id) {
		return dvdMapper.selectReturnAll(id);
	}

	@Override
	public void insertDVD(DVD dvd) {
		dvdMapper.insert(dvd);
	}

	@Override
	public int rentalDVD(Integer userId, List<Integer> dvdIds) {
		int count = 0;
		for(Integer id : dvdIds) {
			count += dvdMapper.rental(userId, id);
		}
		return count;
	}
	
	@Override
	public void returnofDVD(List<Integer> dvdIds) {
		for(Integer id : dvdIds) {
			dvdMapper.returnof(id);
		}
	}

}

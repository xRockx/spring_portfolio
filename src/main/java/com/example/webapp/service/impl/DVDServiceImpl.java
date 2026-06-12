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
	public void rentalDVD(Integer userId, List<Integer> dvdIds) {
		for(Integer id : dvdIds) {
			dvdMapper.rental(userId, id);
		}
	}
	
	@Override
	public void updateDVD(DVD dvd) {
		dvdMapper.update(dvd);
	}

}

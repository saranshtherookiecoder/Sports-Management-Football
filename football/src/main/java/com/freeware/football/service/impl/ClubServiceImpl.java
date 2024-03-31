package com.freeware.football.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeware.football.dao.ClubDao;
import com.freeware.football.model.Club;
import com.freeware.football.service.ClubService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	ClubDao dao;

	@Override
	@Transactional
	public void addClub(Club club) {
		log.info("Adding Club :{}", club);
		dao.addClub(club);

	}

}

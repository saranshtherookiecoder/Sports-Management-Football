package com.freeware.football.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeware.football.dao.LeagueDao;
import com.freeware.football.model.League;
import com.freeware.football.service.LeagueService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LeagueServiceImpl implements LeagueService {

	@Autowired
	LeagueDao dao;
	
	@Override
	@Transactional
	public void addLeague(League league) {
		log.info("Adding League :{}",league);
		dao.save(league);
		
		
	}

}

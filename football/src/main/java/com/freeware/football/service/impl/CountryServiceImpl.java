package com.freeware.football.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeware.football.dao.CountryDao;
import com.freeware.football.model.Country;
import com.freeware.football.service.CountryService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	CountryDao dao;

	@Override
	@Transactional
	public void addCountry(Country country) {
		log.info("Adding country :{}", country);
		dao.addCountry(country);
		
	}

	@Override
	public Country findbyId(Integer id) {
		log.info("Finding Country with id :{}",id);
		return dao.findById(id);
	}

	@Override
	public List<Country> getData(String column, Object value) {
		log.info("Fetching data for the column :{} and value :{}",column,value);
		return dao.getData(column, value);
	}

}

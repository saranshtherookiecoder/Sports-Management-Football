package com.freeware.football.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.freeware.football.model.Country;

@Repository
public interface CountryDao {

	List<Country> getData(String column, Object value);
	
	void addCountry(Country country);
	
	Country findById(Integer id);
	
	
	

}

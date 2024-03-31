package com.freeware.football.service;

import java.util.List;

import com.freeware.football.model.Country;

public interface CountryService {
	
	void addCountry(Country country);
	
	Country findbyId(Integer id);

	List<Country> getData(String column, Object value);
}

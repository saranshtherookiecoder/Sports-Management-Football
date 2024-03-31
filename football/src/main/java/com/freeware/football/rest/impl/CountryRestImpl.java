package com.freeware.football.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeware.football.model.Country;
import com.freeware.football.service.CountryService;

@RestController
@RequestMapping(path = "/Country")
public class CountryRestImpl {

	@Autowired
	CountryService service;

	@PostMapping(path = "/addCountry")
	private void addCountry(@RequestBody(required = true) Country country) {
		service.addCountry(country);
	}
	
	@GetMapping(path = "/getData")
	private List<Country> getData(@RequestParam(value = "column") String column, @RequestParam(value = "value") Object value) {
		return service.getData(column, value);
	}
	
	@GetMapping(path = "/getCountry/{id}")
	private Country getCountry(@PathVariable(value = "id") Integer id) {
		return service.findbyId(id);
	}
}

package com.freeware.football.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeware.football.model.League;
import com.freeware.football.service.LeagueService;

@RestController
@RequestMapping(path = "/League")
public class LeagueRestImpl {

	@Autowired
	LeagueService service;

	@PostMapping(path = "/addLeague", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void addLeague(@RequestBody(required = true) League league) {
		service.addLeague(league);
	}

}

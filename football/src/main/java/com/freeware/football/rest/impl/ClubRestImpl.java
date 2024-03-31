package com.freeware.football.rest.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.freeware.football.model.Club;
import com.freeware.football.service.ClubService;

@RestController
@RequestMapping(path = "/Club")
public class ClubRestImpl {

	@Autowired
	ClubService service;

	@PostMapping(path = "/addClub")
	private void addClub(@RequestBody(required = true) Club club) {
		service.addClub(club);
	}

}

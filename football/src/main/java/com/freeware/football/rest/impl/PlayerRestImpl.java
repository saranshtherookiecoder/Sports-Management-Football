package com.freeware.football.rest.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.freeware.football.model.Player;
import com.freeware.football.service.PlayerService;

@RestController
@RequestMapping(path = "/Player")
public class PlayerRestImpl {

	@Autowired
	PlayerService service;

	@PostMapping(path = "/addPlayer", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void addPlayer(@RequestBody(required = true) Player player) {
		service.addPlayer(player);
	}

	@PostMapping(path = "/updatePlayer", consumes = MediaType.APPLICATION_JSON_VALUE)
	private void updatePlayer(@RequestBody(required = true) Player player) {
		service.UpdatePlayer(player);
	}

	@GetMapping(path = "/getPlayer/{id}")
	private Player getPlayer(@PathVariable(value = "id") Integer id) {
		return service.getPlayerById(id);
	}

	@GetMapping(path = "/getPlayersByClub/{id}")
	private List<Player> getPlayersByClub(@PathVariable(value = "id") Integer clubId) {
		return service.getPlayersByClub(clubId);
	}

	@GetMapping(path = "/getPlayersByCountry/{id}")
	private List<Player> getPlayersByCountry(@PathVariable(value = "id") Integer countryId) {
		return service.getPlayersByCountry(countryId);
	}

	@GetMapping(path = "/getData")
	private List<Player> getData(@RequestParam(value = "column") String column, @RequestParam(value = "value") Object value) {
		return service.getData(column, value);
	}

	@GetMapping(path = "/updateData")
	private String updateData(@RequestParam(value = "column") String column,
			@RequestParam(value = "value") Object value, @RequestParam(value = "matchColumn") String matchColumn,
			@RequestParam(value = "matchValue") Object matchValue) {
		return service.updateData(column, value, matchColumn, matchValue);
	}
	
	@GetMapping(path = "/transferPlayer")
	private Player transferPlayer(@RequestParam(value = "playerId") Integer playerId, @RequestParam(value = "clubId") Integer clubId) {
		return service.transferPlayer(playerId, clubId);
	}

}

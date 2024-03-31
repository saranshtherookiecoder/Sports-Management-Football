package com.freeware.football.service;

import java.util.List;

import com.freeware.football.model.Player;

public interface PlayerService {

	void addPlayer(Player player);
	
	Player getPlayerById(Integer id);

	List<Player> getPlayersByCountry(Integer countryId);

	List<Player> getPlayersByClub(Integer clubId);

	List<Player> getData(String key, Object value);

	void UpdatePlayer(Player player);

	String updateData(String column, Object value, String matchColumn, Object matchValue);

	Player transferPlayer(Integer playerId, Integer clubId);

}

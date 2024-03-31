package com.freeware.football.dao;

import java.util.List;

import com.freeware.football.model.Player;

public interface PlayerDao {
	List<Player> getPlayersByClub(Integer clubid);

	void addPlayer(Player player);

	Player getPlayerById(Integer id);

	List<Player> getPlayersByCountry(Integer countryId);

//	List<Player> getData(String key, Object value);

	Player updatePlayer(Player player);

	String updateData(String column, Object value, String matchColumn, Object matchValue);

	List<Player> getData(String column, Object value, Object condition);


}

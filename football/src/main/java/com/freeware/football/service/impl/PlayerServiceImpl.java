package com.freeware.football.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeware.football.dao.ClubDao;
import com.freeware.football.dao.PlayerDao;
import com.freeware.football.model.Player;
import com.freeware.football.service.PlayerService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerDao dao;

	@Autowired
	ClubDao clubDao;

	@Override
	public void addPlayer(Player player) {
		log.info("Player object inserting is :{}", player);
		dao.addPlayer(player);
	}

	@Override
	public void UpdatePlayer(Player player) {
		log.info("Player object Updating is :{}", player);
		dao.updatePlayer(player);
	}

	@Override
	public Player getPlayerById(Integer id) {
		log.info("fetching player by id :{}", id);
		return dao.getPlayerById(id);

	}

	@Override
	public List<Player> getPlayersByClub(Integer clubId) {
		log.info("fetching player by club with clubid :{}", clubId);
		return dao.getPlayersByClub(clubId);
	}

	@Override
	public List<Player> getPlayersByCountry(Integer countryId) {
		log.info("fetching player by country with countryid :{}", countryId);
		return dao.getPlayersByCountry(countryId);

	}

	@Override
	public List<Player> getData(String column, Object value) {
		log.info("Getting data for column :{} and value :{}", column, value);
		return dao.getData(column, value);
	}

	@Override
	public String updateData(String column, Object value, String matchColumn, Object matchValue) {
		log.info("Updating data for column :{} and value :{} by matching column :{} and value :{}", column, value,
				matchColumn, matchValue);
		return dao.updateData(column, value, matchColumn, matchValue);
	}

	@Override
	public Player transferPlayer(Integer playerId, Integer clubId) {

		log.info("Transferring player with id :{} to club id :{}");
		Player player = dao.getPlayerById(playerId);
		player.setClub(clubDao.findById(clubId));
		return dao.updatePlayer(player);
	}
	
}

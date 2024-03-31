package com.freeware.football.dao;

import java.util.List;

import com.freeware.football.model.Club;

public interface ClubDao {

	void addClub(Club club);

	void updateClub(Club club);

	List<Club> getData(String key, Object value);

	Club findById(Integer clubId);

}

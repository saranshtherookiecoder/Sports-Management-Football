package com.freeware.football.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freeware.football.model.League;

@Repository
public interface LeagueDao extends JpaRepository<League, Integer>{

}
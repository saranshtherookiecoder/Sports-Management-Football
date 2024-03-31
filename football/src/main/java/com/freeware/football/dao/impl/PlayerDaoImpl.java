package com.freeware.football.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freeware.football.dao.ClubDao;
import com.freeware.football.dao.PlayerDao;
import com.freeware.football.model.Player;
import com.freeware.football.utils.Utils;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private EntityManager em;

	@Autowired
	ClubDao clubDao;

	public PlayerDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	@Transactional
	public void addPlayer(Player player) {
		em.persist(player);
	}

	@Override
	@Transactional
	public Player updatePlayer(Player player) {
		return em.merge(player);
	}

	@Override
	public Player getPlayerById(Integer id) {
		return em.find(Player.class, id);

	}

	@Override
	public List<Player> getPlayersByClub(Integer clubId) {
		return em.createNamedQuery("getPlayersByClubId", Player.class).setParameter("clubId", clubId).getResultList();
	}

	@Override
	public List<Player> getPlayersByCountry(Integer countryId) {
		return em.createNamedQuery("getPlayersByCountryId", Player.class).setParameter("countryId", countryId)
				.getResultList();
	}

	@Override
	public List<Player> getData(String column, Object value, Object condition) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Player> cr = cb.createQuery(Player.class);
		Root<Player> root = cr.from(Player.class);
		if (condition != null && condition.equals(">")) { 
			
			cr.select(root).where(cb.greaterThan(Utils.getPath(root, column).as(Object.class),value));
		}
		if (condition != null && condition.equals("<")) {

		} else {

			cr.select(root).where(cb.equal(Utils.getPath(root, column), value));
		}
		TypedQuery<Player> query = em.createQuery(cr);
		List<Player> results = query.getResultList();
		return results;

	}

	@Override
	@Transactional
	public String updateData(String column, Object value, String matchColumn, Object matchValue) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<Player> cr = cb.createCriteriaUpdate(Player.class);
		Root<Player> root = cr.from(Player.class);
		cr.set(column, value);
		cr.where(cb.equal(Utils.getPath(root, matchColumn), matchValue));
		this.em.createQuery(cr).executeUpdate();
		return "Successfully Updated";
	}

}

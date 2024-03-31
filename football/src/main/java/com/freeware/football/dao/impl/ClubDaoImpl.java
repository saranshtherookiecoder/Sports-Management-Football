package com.freeware.football.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freeware.football.dao.ClubDao;
import com.freeware.football.model.Club;
import com.freeware.football.utils.Utils;

@Repository
public class ClubDaoImpl implements ClubDao {

	@Autowired
	private EntityManager em;

	public ClubDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void addClub(Club club) {
		em.persist(club);
	}
	
	@Override
	public void updateClub(Club club) {
		em.merge(club);
	}
	
	@Override
	public List<Club> getData(String key, Object value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Club> cr = cb.createQuery(Club.class);
		Root<Club> root = cr.from(Club.class);
		cr.select(root).where(cb.equal(Utils.getPath(root, key), value));
		TypedQuery<Club> query = em.createQuery(cr);
		List<Club> results = query.getResultList();
		return results;

	}
	
	@Override
	public Club findById(Integer clubId) {
		return em.find(Club.class, clubId);
	}

}

package com.freeware.football.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.freeware.football.dao.CountryDao;
import com.freeware.football.model.Country;
import com.freeware.football.utils.Utils;

@Repository
public class CountryDaoImpl implements CountryDao{
	
	@Autowired
	private EntityManager em;
	

	@Override
	public List<Country> getData(String column, Object value) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Country> cr = cb.createQuery(Country.class);
		Root<Country> root = cr.from(Country.class);
		cr.select(root).where(cb.equal(Utils.getPath(root, column), value));
		TypedQuery<Country> query = em.createQuery(cr);
		List<Country> results = query.getResultList();
		return results;

	}


	@Override
	@Transactional
	public void addCountry(Country country) {
		em.persist(country);
	}


	@Override
	public Country findById(Integer id) {
		return em.find(Country.class, id);
	}
	
	
	

}

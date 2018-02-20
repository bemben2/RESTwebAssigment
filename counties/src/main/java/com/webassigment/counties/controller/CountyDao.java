package com.webassigment.counties.controller;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.webassigment.counties.model.County;

@Stateless
@LocalBean
public class CountyDao {
	@PersistenceContext
	private EntityManager em;

	public List<County> getAll() {
		Query query = em.createNamedQuery("County.findAll", County.class);
		return query.getResultList();
	}

	public County getById(int id) {
		return em.find(County.class, id);
	}

	public void create(County county) {
		em.persist(county);
		
	}

	public void deleteById(int id) {
		em.remove(getById(id));
		
	}

	public void update(County county) {
		em.merge(county);
	}
}

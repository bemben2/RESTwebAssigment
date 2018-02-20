package com.webassigment.counties.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.webassigment.counties.model.County;
import com.webassigment.counties.model.CountyHasNeighbour;

@Stateless
@LocalBean
public class CountyHasNeighbourDao {
	@PersistenceContext
	private EntityManager em;
	@EJB
	private CountyDao countyDao;
	
	public List<County> getNeighboursById(int countyId) {
		Query query = em.createNamedQuery("CountyHasNeighbour.findNeighbourById", CountyHasNeighbour.class);
		query.setParameter("countyId", countyId);
		List<County> neighboursList = new ArrayList<County>();
		List<CountyHasNeighbour> queryResult = (ArrayList<CountyHasNeighbour>)query.getResultList();
		System.out.println(queryResult.size());
		neighboursList.add(countyDao.getById(countyId));
		for (CountyHasNeighbour countyHasNeighbour : queryResult) {
			neighboursList.add(countyDao.getById(countyHasNeighbour.getNeighbourId()));
		}
		return neighboursList;
	}
	
	public List<CountyHasNeighbour> getAll() {
		Query query = em.createNamedQuery("CountyHasNeighbour.findAll", CountyHasNeighbour.class);
		return query.getResultList();
	}

	public CountyHasNeighbour getById(int id) {
		return em.find(CountyHasNeighbour.class, id);
	}

	public void create(CountyHasNeighbour countyHasNeighbour) {
		em.persist(countyHasNeighbour);
		
	}

	public void deleteById(int id) {
		em.remove(getById(id));
		
	}

	public void update(CountyHasNeighbour countyHasNeighbour) {
		em.merge(countyHasNeighbour);
	}

	
	
}

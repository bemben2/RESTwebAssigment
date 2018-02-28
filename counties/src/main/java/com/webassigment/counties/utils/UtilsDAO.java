package com.webassigment.counties.utils;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class UtilsDAO {

	 @PersistenceContext
	    private EntityManager em;
	    
		public void deleteTable(){
			em.createQuery("DELETE FROM County").executeUpdate();
			em.createQuery("DELETE FROM CountyHasNeighbour").executeUpdate();
			
		}
}

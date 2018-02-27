package com.webassigment.counties.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.core.Response;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.webassigment.counties.controller.CountyDao;
import com.webassigment.counties.controller.CountyHasNeighbourDao;
import com.webassigment.counties.model.County;
import com.webassigment.counties.model.CountyHasNeighbour;
import com.webassigment.counties.rest.CountyEndpoint;
import com.webassigment.counties.rest.CountyHasNeighbourEndpoint;
import com.webassigment.counties.rest.RestApplication;

@RunWith(Arquillian.class)
public class CountiesIntegrationTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(JavaArchive.class, "CountiesIntegrationTest.jar")
				.addClasses(County.class, CountyDao.class, CountyEndpoint.class, 
						CountyHasNeighbourEndpoint.class, CountyHasNeighbour.class, 
						CountyHasNeighbourDao.class, RestApplication.class)
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@EJB
	private CountyEndpoint countyEndpoint;
	@EJB
	private CountyDao countyDao;
	
	@EJB
	private CountyHasNeighbourEndpoint countyHasNeighbourEndpoint;
	
	@Before
	public void setUp() {
		//this function means that we start with an empty table
		//And add one wine
		//it should be possible to test with an in memory db for efficiency
		//utilsDAO.deleteTable();
//		County county = new County();
//		county.setAreaRank(11);
//		county.setAreaTotal(2332);
//		county.setCapital("Navan");
//		county.setId(1);
//		county.setFlag("metah.jpg");
//		county.setName("Meath");
//		county.setNeighbourNo(5);
//		county.setMotto("Together forever");
//		county.setPopulation(123432);
//		county.setProvince("Lenister");
//		
//		countyDao.create(county);
	}
		@Test
		public void testGetAllCounties() {
			Response response = countyEndpoint.listAll();
			response.getEntity();
			List<County> list = (List<County>) response.getEntity();
			assertEquals("Get all data", list.size(), 6);
			assertEquals("Get all data", response.getStatus(), 200);
		}
	
}

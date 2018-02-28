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
import com.webassigment.counties.utils.UtilsDAO;

@RunWith(Arquillian.class)
public class CountiesIntegrationTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(JavaArchive.class, "CountiesIntegrationTest.jar")
				.addClasses(County.class, CountyDao.class, CountyEndpoint.class, 
						CountyHasNeighbourEndpoint.class, CountyHasNeighbour.class, 
						CountyHasNeighbourDao.class, RestApplication.class, UtilsDAO.class)
				.addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@EJB
	private CountyEndpoint countyEndpoint;
	@EJB
	private CountyDao countyDao;
	@EJB
	private UtilsDAO utilsDao;
	@EJB
	private CountyHasNeighbourEndpoint countyHasNeighbourEndpoint;
	
	@Before
	public void setUp() {
		utilsDao.deleteTable();
		County county = new County();
		county.setId(1);
		county.setAreaRank(11);
		county.setAreaTotal(2332);
		county.setCapital("Navan");
		county.setFlag("metah.jpg");
		county.setName("Meath");
		county.setNeighbourNo(5);
		county.setMotto("Together forever");
		county.setPopulation(123432);
		county.setProvince("Lenister");
		countyDao.create(county);
	}
		@Test
		public void testGETAllCounties() {
			Response response = countyEndpoint.listAll();
			List<County> list = (List<County>) response.getEntity();
			assertEquals( 1, list.size());
			assertEquals( 200, response.getStatus());
		}
	
		@Test
		public void testGETCountyById() {
			Response response = countyEndpoint.findById(1);
			County county = (County) response.getEntity();
			assertEquals(county.getId(), 1);
			assertEquals(200,response.getStatus());
			
		}
		
		@Test
		public void testGETCountyByInvalidId() {
			Response response = countyEndpoint.findById(7);
			County county = (County) response.getEntity();
			assertEquals(404, response.getStatus());
			
		}
		@Test
		public void testGETCountyByName() {
			Response response = countyEndpoint.findByName("Meath");
			List<County> list = (List<County>) response.getEntity();
			assertEquals(1, list.size());
			assertEquals(200, response.getStatus());
		}
		
		@Test
		public void testGETCountyByInvalidName() {
			Response response = countyEndpoint.findByName("X");
			List<County> list = (List<County>) response.getEntity();
			assertEquals(0, list.size());
			assertEquals(200, response.getStatus());
		}
		
		@Test
		public void testDELETCountyByID() {
			Response response = countyEndpoint.deleteById(1);
			List<County> list = (List<County>) countyEndpoint.listAll().getEntity();
			assertEquals(0, list.size());
			assertEquals(204, response.getStatus());
		}
		@Test
		public void testPUTCountyUpdate() {
			County county = new County();
			county.setAreaRank(11);
			county.setAreaTotal(2332);
			county.setCapital("Antrim");
			county.setId(1);
			county.setFlag("antrim.jpg");
			county.setName("Antrim");
			county.setNeighbourNo(5);
			county.setMotto("Through Trial to Triumphs");
			county.setPopulation(123432);
			county.setProvince("UlsterUPDATED");
			
			Response response = countyEndpoint.update(11, county);
//			County county2 = (County) response.getEntity();;
//			assertEquals(county.getId(), county2.getId());
//			assertEquals(county.getProvince(), county2.getProvince());
			assertEquals( 204, response.getStatus());
		}
		@Test
		public void testPOSTCounty() {
			County county = new County();
			county.setAreaRank(11);
			county.setAreaTotal(2332);
			county.setCapital("Antrim");
			county.setId(2);
			county.setFlag("antrim.jpg");
			county.setName("Antrim");
			county.setNeighbourNo(5);
			county.setMotto("Through Trial to Triumphs");
			county.setPopulation(123432);
			county.setProvince("Ulster");
			Response response = countyEndpoint.create(county);
			County county2 = (County) response.getEntity();;
			assertEquals(county.getId(), county2.getId());
			assertEquals( response.getStatus(), 200);
		}

}

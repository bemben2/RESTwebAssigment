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
public class CountyHasNeighbourTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "CountiesIntegrationTest.jar")
				.addClasses(County.class, CountyDao.class, CountyEndpoint.class, CountyHasNeighbourEndpoint.class,
						CountyHasNeighbour.class, CountyHasNeighbourDao.class, RestApplication.class, UtilsDAO.class)
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
	@EJB
	private CountyHasNeighbourDao countyHasNeighbourDao;

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
		county.setNeighbourNo(2);
		county.setMotto("Together forever");
		county.setPopulation(123432);
		county.setProvince("Lenister");
		countyDao.create(county);

		county = new County();
		county.setId(2);
		county.setAreaRank(11);
		county.setAreaTotal(2332);
		county.setCapital("Antrim");
		county.setFlag("metah.jpg");
		county.setName("Antrim");
		county.setNeighbourNo(5);
		county.setMotto("Together forever");
		county.setPopulation(123432);
		county.setProvince("Ulster");
		countyDao.create(county);
		county = new County();
		county.setId(3);
		county.setAreaRank(11);
		county.setAreaTotal(2332);
		county.setCapital("Galway");
		county.setFlag("metah.jpg");
		county.setName("Galway");
		county.setNeighbourNo(5);
		county.setMotto("Together forever");
		county.setPopulation(123432);
		county.setProvince("Ulster");
		countyDao.create(county);
		CountyHasNeighbour chn = new CountyHasNeighbour();
		chn.setId(1);
		chn.setCountyId(1);
		chn.setNeighbourId(2);
		countyHasNeighbourDao.create(chn);
		chn = new CountyHasNeighbour();
		chn.setId(2);
		chn.setCountyId(1);
		chn.setNeighbourId(3);
		countyHasNeighbourDao.create(chn);
	}
	
	@Test
	public void testgetAllCountyHasNeighbours() {
		List<CountyHasNeighbour> list = countyHasNeighbourDao.getAll();
		assertEquals(2, list.size());
	}
	
	@Test
	public void testUpdateCountyHasNeighbours() {
		CountyHasNeighbour chn = new CountyHasNeighbour();
		chn.setId(1);
		chn.setCountyId(1);
		chn.setNeighbourId(3);
		countyHasNeighbourDao.update(chn);

		CountyHasNeighbour chn2 = countyHasNeighbourDao.getById(1);
		
		assertEquals(chn.getNeighbourId(), chn2.getNeighbourId());
	}
	
	@Test
	public void testDeleteCountyHasNeighboursByIdGetById() {
		countyHasNeighbourDao.deleteById(1);
		CountyHasNeighbour chn = countyHasNeighbourDao.getById(1);
		assertNull(chn);
	}
	
	@Test
	public void testFindCountyHasNeighboursByIdGetById() {
		CountyHasNeighbour chn = countyHasNeighbourDao.getById(1);
		assertEquals(1, chn.getId());
	}
	
	@Test
	public void testGETNeighboursCountiesById() {
		Response response = countyHasNeighbourEndpoint.findNeigboursById(1);
		List<County> list = (List<County>) response.getEntity();
		assertEquals(3, list.size());
		assertEquals(200, response.getStatus());
	}
}

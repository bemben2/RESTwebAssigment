package com.webassigment.counties.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.webassigment.counties.controller.CountyHasNeighbourDao;
import com.webassigment.counties.model.County;
import com.webassigment.counties.model.CountyHasNeighbour;

@Stateless
@LocalBean
@Path("/neighbours")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CountyHasNeighbourEndpoint {

	@EJB
	private CountyHasNeighbourDao countyHasNeighbourDao;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findNeigboursById(@PathParam("id") final int id) {
		final List<County> counties = countyHasNeighbourDao.getNeighboursById(id);
		if (counties == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.ok(counties).build();
	}
}

//	@GET
//	@Produces({ MediaType.APPLICATION_JSON })
//	public Response listAll() {
//		final List<CountyHasNeighbour> countyHasNeighbours = countyHasNeighbourDao.getAll();
//		if (countyHasNeighbours == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.status(200).entity(countyHasNeighbours).build();
//	}

//	@GET
//	@Path("/{id:[0-9][0-9]*}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Consumes("application/json")
//	public Response findById(@PathParam("id") final int id) {
//		CountyHasNeighbour countyHasNeighbour = countyHasNeighbourDao.getById(id);
//		if (countyHasNeighbour == null) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		return Response.ok(countyHasNeighbour).build();
//	}

//	@PUT
//	@Path("/{id:[0-9][0-9]*}")
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Consumes("application/json")
//	public Response update(@PathParam("id") Long id, final CountyHasNeighbour countyHasNeighbour) {
//		countyHasNeighbourDao.update(countyHasNeighbour);
//		return Response.noContent().build();
//	}

//	@DELETE
//	@Path("/{id:[0-9][0-9]*}")
//	public Response deleteById(@PathParam("id") final int id) {
//		countyHasNeighbourDao.deleteById(id); 
//		return Response.noContent().build();
//	}

	
//	@POST
//	@Produces({ MediaType.APPLICATION_JSON })
//	@Consumes("application/json")
//	public Response create(final CountyHasNeighbour countyHasNeighbour) {
//		countyHasNeighbourDao.update(countyHasNeighbour);
//		return Response.status(200).entity(countyHasNeighbour).build();
//	}


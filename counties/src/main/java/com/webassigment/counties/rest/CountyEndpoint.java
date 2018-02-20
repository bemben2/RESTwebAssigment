package com.webassigment.counties.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webassigment.counties.controller.CountyDao;
import com.webassigment.counties.model.County;

@RequestScoped
@Path("/counties")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class CountyEndpoint {

	@EJB
	private CountyDao countyDao;
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes("application/json")
	public Response create(final County county) {
		countyDao.create(county);
		return Response.status(200).entity(county).build();
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") final int id) {
		//TODO: retrieve the county 
		County county = countyDao.getById(id);
		return Response.ok(county).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		//TODO: retrieve the counties 
		final List<County> counties = countyDao.getAll();
		return Response.status(200).entity(counties).build();
	}

	@PUT
	@Path("/{id:[0-9][0-9]*}")
	@Consumes("application/json")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response update(@PathParam("id") Long id, final County county) {
		countyDao.update(county);
		return Response.noContent().build();
	}

	@DELETE
	@Path("/{id:[0-9][0-9]*}")
	public Response deleteById(@PathParam("id") final int id) {
		countyDao.deleteById(id);
		System.out.println("Delete");
		return Response.noContent().build();
	}

}

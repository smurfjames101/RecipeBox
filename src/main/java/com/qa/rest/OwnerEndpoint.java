package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.OwnerService;

@Path("/owner")
public class OwnerEndpoint {

	@Inject
	private OwnerService service;
	
	@Path("/getAllOwners")
	@GET
	@Produces({ "application/json" })
	public String getAllOwners()
	{
		return service.getAllOwners();
	}
	
	@Path("/cycleOwners/{name}")
	@GET
	@Produces({ "application/json" })
	public int cycleRecipes(@PathParam("name") String name)
	{
			return service.cycleOwners(name);
	}
	
	@Path("/getAMovie/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnOwner(@PathParam("owner_id") Long owner_id) {
		return service.getAnOwner(owner_id);
	}

	@Path("/createOwner")
	@POST
	@Produces({ "application/json" })
	public String addOwner(String owner) {
		return service.createOwner(owner);
	}

	@Path("/deleteOwner/{owner_id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteOwner(@PathParam("owner_id") Long owner_id) {
		return service.deleteOwner(owner_id);
	}

	public void setService(OwnerService service) {
		this.service = service;
	}

}

package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.RecipeService;

@Path("/recipe")
public class RecipeEndpoint {
	
	@Inject
	private RecipeService service;
	
	@Path("/getAllRecipes")
	@GET
	@Produces({"application/json"})
	public String getAllRecipes() {
		return service.getAllRecipes();
	}
	@Path("/cyclesRecipes/{recipeName}")
	@GET
	@Produces({"application/json"})
	public int cycleRecipes(@PathParam("recipeName") String recipeName)
	{
		return service.cycleRecipes(recipeName);
	}
	
	@Path("/getARecipe/{id}")
	@GET
	@Produces({"application/json"})
	public String getARecipe(@PathParam("id") Long id)
	{
		return service.getARecipe(id);
	}
	
	@Path("/createRecipe")
	@POST
	@Produces({"application/json"})
	public String createRecipe(String recipe)
	{
		return service.createRecipe(recipe);
	}
	
	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteRecipe(@PathParam("id") Long id)
	{
		return service.deleteRecipe(id);
	}
	
	public void setService(RecipeService service) {
		this.service = service;
	}
	
}

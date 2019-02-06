package com.qa.persitence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persitence.domain.Recipe;
import com.qa.util.JSONUtil;

public class RecipeDBRepository implements RecipeRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;
	
	@Override
	@Transactional(REQUIRED)
	public String createRecipe(String recipe) {
			Recipe aRecipe = util.getObjectForJSON(recipe, Recipe.class);
			manager.persist(aRecipe);
		return "{\"message\": \"Recipe has been added\"}";
	}

	@Override
	public String getAllRecipes() {
		Query query = manager.createQuery("Select a FROM Recipe a");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();
		
		return util.getJSONForObject(recipes);
	}

	@Override
	public String getARecipe(Long id) {
		return util.getJSONForObject(manager.find(Recipe.class, id));
	}


	@Override
	@Transactional(REQUIRED)
	public String deleteRecipe(Long id) {
		Recipe recipeInDB = util.getObjectForJSON(getARecipe(id), Recipe.class);
		if (manager.contains(manager.find(Recipe.class, id))) {

			manager.remove(manager.find(Recipe.class, id));
		}
		return "{\"message\": \"recipe sucessfully deleted\"}";
	}

	@Override
	public int cycleRecipes(String recipeName) {
		Query query = manager.createQuery("Select a FROM recipe a");
		Collection<Recipe> recipes = (Collection<Recipe>) query.getResultList();

		List<Recipe> validList = recipes.stream().filter(n -> n.getRecipe().equals(recipeName)).collect(Collectors.toList());

		return validList.size();
	}
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}	
	
	@Override
	public String updateRecipe(String recipe, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

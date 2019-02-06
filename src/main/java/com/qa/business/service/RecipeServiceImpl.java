package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persitence.repository.RecipeRepository;

public class RecipeServiceImpl implements RecipeService{
	@Inject
	private RecipeRepository repo;

	@Override
	public String createRecipe(String recipe) {
		if(recipe.contains("bacon"))
		{
			return "Can't add recipe";
		}
		
		if(recipe.contains("mushrooms"))
		{
			return "Can't add recipe";
		}
		
		return repo.createRecipe(recipe);
	}

	@Override
	public String getAllRecipes() {
		return repo.getAllRecipes();
	}

	@Override
	public String getARecipe(Long id) {
		return repo.getARecipe(id);
	}

	@Override
	public String updateRecipe(String recipe, Long id) {
		return repo.updateRecipe(recipe, id);
	}

	@Override
	public String deleteRecipe(Long id) {
		return repo.deleteRecipe(id);
	}

	@Override
	public int cycleRecipes(String recipeName) {
		return repo.cycleRecipes(recipeName);
	}

}

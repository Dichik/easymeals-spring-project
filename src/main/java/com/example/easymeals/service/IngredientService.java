package com.example.easymeals.service;

import com.example.easymeals.entity.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getIngredientsByRecipeId(Long recipeId);

}

package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.IngredientDto;
import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.entity.Recipe;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

public interface RecipeService {

    List<Recipe> getAll(List<Long> ids);

    List<Recipe> getAll();

    Optional<Recipe> findById(Long id);

    Recipe save(RecipeDto recipeDto);

    Optional<Recipe> update(Long id, RecipeDto recipeDto);

    void deleteById(Long id);

    List<Recipe> getAllFiltered(LinkedHashMap data);

    List<IngredientDto> getIngredientsFromData(LinkedHashMap data);
}

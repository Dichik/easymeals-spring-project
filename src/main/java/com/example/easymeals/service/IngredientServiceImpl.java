package com.example.easymeals.service;

import com.example.easymeals.entity.Ingredient;
import com.example.easymeals.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getIngredientsByRecipeId(Long recipeId) {
        return ingredientRepository.getIngredientByRecipeId(recipeId);
    }

}

package com.example.easymeals.repository;

import com.example.easymeals.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> getIngredientByRecipeId(Long recipeId);

}

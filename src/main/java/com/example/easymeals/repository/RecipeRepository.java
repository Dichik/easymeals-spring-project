package com.example.easymeals.repository;

import com.example.easymeals.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Modifying @Transactional
    @Query(value = "UPDATE recipe SET score=1.2, number_of_votes=number_of_votes+1 WHERE id=1",
        nativeQuery = true)
    void updateRating(Double score, Long recipeId);

}

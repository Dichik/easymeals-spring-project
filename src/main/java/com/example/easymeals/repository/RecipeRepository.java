package com.example.easymeals.repository;

import com.example.easymeals.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Modifying @Transactional
    @Query(value = "UPDATE recipe SET score=(score + ?1)/(2), number_of_votes=number_of_votes+1 WHERE id=?2",
        nativeQuery = true)
    void updateRating(Double score, Long recipeId);

    @Modifying @Transactional
    @Query(value = "UPDATE recipe SET score=(score + (?2 - ?1)/(number_of_votes) ) WHERE id=?3",
            nativeQuery = true)
    void revote(Double oldScore, Double newScore, Long recipeId);

}

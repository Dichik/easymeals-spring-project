package com.example.easymeals.repository;

import com.example.easymeals.entity.Ratings;
import com.example.easymeals.entity.RatingsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {

    Boolean existsRatingsByUserId(Long userId);

    Optional<Ratings> findByRecipeId(Long recipeId);

    Boolean existsByUserIdAndRecipeId(Long userId, Long recipeId);

    Optional<Ratings> findByUserIdAndRecipeId(Long userId, Long recipeId);

    List<Ratings> findByUserId(Long userId);

}

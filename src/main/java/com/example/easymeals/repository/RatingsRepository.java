package com.example.easymeals.repository;

import com.example.easymeals.entity.Ratings;
import com.example.easymeals.entity.RatingsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, RatingsId> {

    Boolean existsRatingsByUserId(Long userId);

    Optional<Ratings> findByRecipeId(Long userId);

}

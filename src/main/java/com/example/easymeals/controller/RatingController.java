package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.dto.RatingsDto;
import com.example.easymeals.repository.RatingsRepository;
import com.example.easymeals.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingsRepository ratingsRepository;
    private final RecipeRepository recipeRepository;
// TODO get all ratings per user
    @PostMapping
    public ResponseEntity<RatingsDto> rateRecipe(@Valid @RequestBody RatingsDto ratingsDto) {
        if(!ratingsRepository.existsRatingsByUserId(ratingsDto.getUserId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        recipeRepository.updateRating(ratingsDto.getScore(), ratingsDto.getRecipeId());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

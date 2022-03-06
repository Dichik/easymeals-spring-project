package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.dto.RatingsDto;
import com.example.easymeals.entity.Ratings;
import com.example.easymeals.repository.RatingsRepository;
import com.example.easymeals.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/rating")
public class RatingController {

    private final RatingsRepository ratingsRepository;
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

//    TODO move to service all that things

    @PostMapping
    public ResponseEntity<RatingsDto> rateRecipe(@Valid @RequestBody RatingsDto ratingsDto) {
        /* If we haven't already marked this recipe, we just create new one */

        if (!ratingsRepository.existsByUserIdAndRecipeId(
                ratingsDto.getUserId(), ratingsDto.getRecipeId())) {

            recipeRepository.updateRating(ratingsDto.getScore(), ratingsDto.getRecipeId());
            ratingsRepository.save(modelMapper.map(ratingsDto, Ratings.class));

            return ResponseEntity.status(HttpStatus.OK).build();
        }

        Optional<Ratings> ratings = ratingsRepository.findByUserIdAndRecipeId(
                ratingsDto.getUserId(), ratingsDto.getRecipeId()
        );

        @NotNull Double previousMark = ratings.get().getScore();
        recipeRepository.revote(previousMark, ratingsDto.getScore(), ratingsDto.getRecipeId());
        ratingsRepository.save(modelMapper.map(ratingsDto, Ratings.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/{userId:[\\d]+}")
    public List<RatingsDto> getAllUserRatings(@Valid @PathVariable Long userId) {
        return ratingsRepository.findByUserId(userId)
                .stream().map(ratings -> modelMapper.map(ratings, RatingsDto.class))
                .collect(Collectors.toList());
    }

}

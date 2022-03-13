package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.dto.RatingsDto;
import com.example.easymeals.entity.Ratings;
import com.example.easymeals.service.RatingsService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/rating")
public class RatingController {

    private final RatingsService ratingsService;
    private final ModelMapper modelMapper;

    // TODO think if we need RatingsDto ???

    @PostMapping
    public ResponseEntity<Ratings> rateRecipe(
            @Valid @RequestBody RatingsDto ratingsDto) {
        return ResponseEntity.ok(ratingsService.rate(ratingsDto));
    }

    @GetMapping("/{userId:[\\d]+}")
    public List<RatingsDto> getAllUserRatings(@Valid @PathVariable Long userId) {
        return ratingsService.getAllPerUser(userId)
                .stream().map(ratings -> modelMapper.map(ratings, RatingsDto.class))
                .collect(Collectors.toList());
    }

}

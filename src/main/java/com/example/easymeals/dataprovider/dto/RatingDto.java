package com.example.easymeals.dataprovider.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingDto {

    @Parsed(field = "recipeId")
    private Long recipeId;

    @Parsed(field = "score")
    private Double score;

    @Parsed(field = "numberOfVotes")
    private Long numberOfVotes;

}

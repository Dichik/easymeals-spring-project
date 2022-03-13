package com.example.easymeals.dataprovider.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto {
    @Parsed(field = "id")
    private Long id;

    @Parsed(field = "title")
    private String title;

    @Parsed(field = "score")
    private Double score;

    @Parsed(field = "numberOfVotes")
    private Long numberOfVotes;

    private List<IngredientDto> ingredientList;

}

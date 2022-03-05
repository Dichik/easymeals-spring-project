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
public class RecipeDto {
//    TODO think about correct fields
    @Parsed(field = "title")
    private String title;

    @Parsed(field = "rating")
    private Double rating;
}

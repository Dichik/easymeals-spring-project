package com.example.easymeals.dataprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RatingsDto {
    private Long userId;
    private Long recipeId;
    private Double score;
}

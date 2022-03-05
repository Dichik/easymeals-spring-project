package com.example.easymeals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingsId implements Serializable {
    private Long userId;
    private Long recipeId;
}

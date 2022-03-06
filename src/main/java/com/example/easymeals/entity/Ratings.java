package com.example.easymeals.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ratings")
@IdClass(RatingsId.class)
public class Ratings {

    @Id private Long userId;
    @Id private Long recipeId;

    private Double score;

}

package com.example.easymeals.entity;

import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating")
public class Rating {

    @Id
    @OneToOne(targetEntity = Recipe.class)
    private Long recipeId;

    private Double score = 0.0;
    private Long numberOfVotes = 0L;

}

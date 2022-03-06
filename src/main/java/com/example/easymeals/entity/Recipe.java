package com.example.easymeals.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
// TODO finish Recipe configuration
    private String title;
    private Double score = 0.0;
    private Long numberOfVotes = 0L;

}

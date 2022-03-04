package com.example.easymeals.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String firstName;
    private String secondName;

    @Email
    private String email;

    @Pattern(regexp = "\\w{5,}")
    private String password;

}

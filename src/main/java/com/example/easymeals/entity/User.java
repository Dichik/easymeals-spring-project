package com.example.easymeals.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;
    private String firstName;
    private String secondName;

    @Email(message = "Email is not valid.")
    private String email;

    @Pattern(regexp = "^\\w{5,}$")
    private String password;

    @Pattern(regexp = "^\\w{10}$")
    private String phone;
}

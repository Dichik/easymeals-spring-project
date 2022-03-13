package com.example.easymeals.entity;

import com.example.easymeals.entity.enums.Genre;
import com.example.easymeals.entity.enums.MeasurementSystem;
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
    @Id @Column(unique = true)
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

    private Genre genre;
    private String imagePath;
    private MeasurementSystem measurementSystem;
}
/*
Possible solution for storing image
parsed before and then
save to folder and save path to image
them saved image send to user
is it possible to

https://www.baeldung.com/spring-controller-return-image-file

* */

package com.example.easymeals.dataprovider.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @Parsed(field = "username")
    private String username;

    @Parsed(field = "firstName")
    private String firstName;

    @Parsed(field = "secondName")
    private String secondName;

    @Parsed(field = "email")
    private String email;

    @Parsed(field = "password")
    private String password;

    @Parsed(field = "phone")
    private String phone;

}

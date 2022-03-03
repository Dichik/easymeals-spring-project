package com.example.easymeals.dataprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    // @parsed ???
    private String username;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private String phone;

}

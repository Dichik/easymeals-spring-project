package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.UserDto;
import com.example.easymeals.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findUserById(Long id);

    User save(UserDto userDto);

    Optional<User> update(Long id, UserDto userDto);

    void deleteById(Long id);

}

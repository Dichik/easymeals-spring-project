package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.SpoonacularDataProvider;
import com.example.easymeals.dataprovider.dto.UserDto;
import com.example.easymeals.entity.User;
import com.example.easymeals.repository.UserRepository;
import com.example.easymeals.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.findAll().stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    // TODO regular pattern for id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {

        return ResponseEntity.noContent().build(); // <- when we want to return response without content
    }

}

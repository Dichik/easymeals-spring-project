package com.example.easymeals.controller;

import com.example.easymeals.entity.User;
import com.example.easymeals.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // TODO regular pattern for id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        if(!userRepository.existsById(id)) {
            // TODO add exceptions types
        }
        return ResponseEntity.ok(userRepository.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        if(!userRepository.existsById(id)) {
            // TODO throw exception
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // <- when we want to return response without content
    }

}

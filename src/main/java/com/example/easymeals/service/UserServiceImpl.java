package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.UserDto;
import com.example.easymeals.entity.User;
import com.example.easymeals.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.crypto.spec.PSource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> update(Long id, UserDto userDto) {
        return userRepository.findById(id).map(source -> {
            User user = modelMapper.map(userDto, User.class);
            user.setId(id);
            return userRepository.save(user);
        });
    }

    @Override
    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.info(e.getMessage(), e);
        }
    }
}

package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.entity.Recipe;
import com.example.easymeals.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Recipe> getAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipeRepository.findById(id);
    }

    @Override
    public Recipe save(RecipeDto recipeDto) {
        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
        return recipe;
    }

    @Override
    public Optional<Recipe> update(Long id, RecipeDto recipeDto) {
        return recipeRepository.findById(id).map(source -> {
            Recipe recipe = modelMapper.map(recipeDto, Recipe.class);
            recipe.setId(id);
            return recipe;
        });
    }

    @Override
    public void deleteById(Long id) {
        try {
            recipeRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.info(e.getMessage(), e);
        }
    }
}

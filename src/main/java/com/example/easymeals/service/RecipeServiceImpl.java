package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.entity.Recipe;
import com.example.easymeals.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return recipeRepository.save(recipe);
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

    @Override
    public List<Recipe> getAllFiltered(final LinkedHashMap data) {
//        TODO add checking if fields exists and throw exception if not
        List<LinkedHashMap> result = ((List<LinkedHashMap>) data.get("ingredients"));
        List<String> answer = result.stream()
                .map(map -> map.get("name").toString())
                .collect(Collectors.toList());
        int returnObjects = (int) data.get("return_objects");
        int skip = (int) data.get("skip");

        List<Recipe> recipes = getAll();
//        recipes.sort((o1, o2) -> {
//            if(o1.getRating() < o2.getRating()) {
//                return 1;
//            }
//            return -1;
//        });
        return recipes;
    }
}

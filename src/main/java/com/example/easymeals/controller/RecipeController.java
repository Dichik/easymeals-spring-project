package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.SpoonacularDataProvider;
import com.example.easymeals.dataprovider.dto.IngredientDto;
import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.exception.InvalidIdentifierException;
import com.example.easymeals.service.IngredientService;
import com.example.easymeals.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    private final RecipeService recipeService;
    private final ModelMapper modelMapper;
    private final IngredientService ingredientService;

    private final SpoonacularDataProvider dataProvider;

    @GetMapping("/test")
    public void test() {
        dataProvider.loadData();
    }

    @GetMapping
    public List<RecipeDto> getRecipes(@RequestBody LinkedHashMap data) {

        Set<String> ingredientsInBasketNames = recipeService.getIngredientsFromData(data)
                .stream().map(IngredientDto::getName)
                .collect(Collectors.toSet());

        return recipeService.getAllFiltered(data).stream()
                .map(recipe -> {
                    RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

                    List<IngredientDto> ingredientsByRecipeId = ingredientService
                            .getIngredientsByRecipeId(recipe.getId())
                            .stream().map(ingredient -> {
                                IngredientDto ingredientDto = modelMapper.map(ingredient, IngredientDto.class);
                                Boolean itemInBasket = ingredientsInBasketNames.contains(ingredientDto.getName());
                                ingredientDto.setItemInBasket(itemInBasket);
                                return ingredientDto;
                            }).collect(Collectors.toList());

                    recipeDto.setIngredientList(ingredientsByRecipeId);
                    return recipeDto;
                }).collect(Collectors.toList());
    }

    @GetMapping("/{id:[\\d]+}")
    public ResponseEntity<RecipeDto> getRecipeById(@PathVariable Long id) {
        return recipeService.findById(id)
                .map(recipe -> ResponseEntity.ok(modelMapper.map(recipe, RecipeDto.class)))
                .orElseThrow(() -> new InvalidIdentifierException(id));
    }

    @PostMapping
    public RecipeDto create(@Valid @RequestBody RecipeDto recipeDto) {
        return modelMapper.map(recipeService.save(recipeDto), RecipeDto.class);
    }

    @PutMapping("/{id:[\\d]+}")
    public ResponseEntity<RecipeDto> update(
            @PathVariable Long id,
            @RequestBody RecipeDto recipeDto) {
        return recipeService.update(id, recipeDto)
                .map(source -> ResponseEntity.ok(modelMapper.map(source, RecipeDto.class)))
                .orElseThrow(() -> new InvalidIdentifierException(id));
    }

    @DeleteMapping("/{id:[\\d]+}")
    public ResponseEntity<RecipeDto> delete(@PathVariable Long id) {
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

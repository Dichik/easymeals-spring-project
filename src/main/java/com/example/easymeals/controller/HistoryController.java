package com.example.easymeals.controller;

import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.entity.History;
import com.example.easymeals.repository.RecipeRepository;
import com.example.easymeals.service.HistoryService;
import com.example.easymeals.service.RecipeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/history")
public class HistoryController {

    private final RecipeService recipeService;
    private final HistoryService historyService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<RecipeDto> getAll() {
        List<Long> ids = historyService.getAll().stream()
                .map(History::getRecipeId)
                .collect(Collectors.toList());
        return recipeService.getAll(ids).stream()
                .map(recipe -> modelMapper.map(recipe, RecipeDto.class))
                .collect(Collectors.toList());
    }

    @DeleteMapping
    public ResponseEntity<RecipeDto> clear() {
        return ResponseEntity.noContent().build();
    }

}

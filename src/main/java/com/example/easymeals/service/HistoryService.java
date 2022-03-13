package com.example.easymeals.service;

import com.example.easymeals.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> getAll();

    void removeFromHistory(Long recipeId);

    History add(Long recipeId);

    void clear();

}

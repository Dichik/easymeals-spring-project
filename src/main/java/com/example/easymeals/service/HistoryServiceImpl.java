package com.example.easymeals.service;

import com.example.easymeals.entity.History;
import com.example.easymeals.exception.AlreadyExistsException;
import com.example.easymeals.exception.InvalidIdentifierException;
import com.example.easymeals.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public List<History> getAll() {
        return historyRepository.findAll();
    }

    @Override
    public void removeFromHistory(Long recipeId) {
        if(!historyRepository.existsById(recipeId)) {
            throw new InvalidIdentifierException(recipeId);
        }
        historyRepository.deleteById(recipeId);
    }

    @Override
    public History add(Long recipeId) {
        History history = new History(recipeId);
        if(historyRepository.existsById(recipeId)) {
            throw new AlreadyExistsException(recipeId);
        }
        return historyRepository.save(history);
    }

    @Override
    public void clear() {
        historyRepository.deleteAll();
    }
}

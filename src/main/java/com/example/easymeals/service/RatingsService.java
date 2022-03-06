package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.RatingsDto;
import com.example.easymeals.entity.Ratings;

import java.util.List;

public interface RatingsService {

    List<Ratings> getAllPerUser(Long userId);

    Ratings rate(RatingsDto ratingsDto);

}

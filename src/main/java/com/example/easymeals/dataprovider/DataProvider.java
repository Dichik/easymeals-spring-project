package com.example.easymeals.dataprovider;


import com.example.easymeals.entity.Recipe;
import java.util.stream.Stream;

public interface DataProvider {
    Stream<Recipe> loadData();
}

package com.example.easymeals.clients;

import com.example.easymeals.dataprovider.dto.RecipeDto;
import com.example.easymeals.entity.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@NoArgsConstructor
public class SpoonacularClient {

    private final String MAIN_RECIPE_URL = "https://api.spoonacular.com/recipes/complexSearch?apiKey=";
    private final String API_KEY = "fa62df8d2bd1463d93ce67caff6959c7";

    //    TODO you get list of all recipes and per each one
    public List<RecipeDto> loadData() {
        return null;
        /*
        HttpResponse<String> response = getRecipes(1, 0);
        JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response).body());
        String totalResultsString = jsonObject.get("totalResults").toString();

        int totalResults = Integer.parseInt(totalResultsString);

        List<RecipeDto> recipes = new ArrayList<>();

        for (int i = 0; i < totalResults; ++i) {
            int number;
            if (i + 100 < totalResults) number = 100;
            else number = totalResults % 100;
            int offset = i;

            response = getRecipes(number, offset);
            recipes.addAll(getRecipesFromResponse(response));
        }

        return recipes;
         */
    }

    private List<RecipeDto> getRecipesFromResponse(HttpResponse<String> response) {
        JSONObject jsonObject = new JSONObject(Objects.requireNonNull(response).body());
        JSONArray array = jsonObject.getJSONArray("results");
        return IntStream.range(0, array.length()).mapToObj(i -> {
                    try {
                        return new ObjectMapper().readValue(array.get(i).toString(), RecipeDto.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private HttpResponse<String> getRecipes(int number, int offset) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(MAIN_RECIPE_URL + API_KEY + "&number=" + number + "&offset=" + offset))
                .header("content-type", "application/json")
                .method("GET", HttpRequest.BodyPublishers.ofString(""))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}

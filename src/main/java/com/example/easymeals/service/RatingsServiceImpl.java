package com.example.easymeals.service;

import com.example.easymeals.dataprovider.dto.RatingsDto;
import com.example.easymeals.entity.Ratings;
import com.example.easymeals.entity.RatingsId;
import com.example.easymeals.repository.RatingsRepository;
import com.example.easymeals.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class RatingsServiceImpl implements RatingsService {

    private final RatingsRepository ratingsRepository;
    private final RecipeRepository recipeRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Ratings> getAllPerUser(Long userId) {
        return ratingsRepository.findByUserId(userId);
    }

    @Override
    public Ratings rate(RatingsDto ratingsDto) {
        /* If we haven't already marked this recipe, we just create new one */

        if (!ratingsRepository.existsByUserIdAndRecipeId(
                ratingsDto.getUserId(), ratingsDto.getRecipeId())) {

            recipeRepository.updateRating(ratingsDto.getScore(), ratingsDto.getRecipeId());
            Ratings ratings = modelMapper.map(ratingsDto, Ratings.class);
            return ratingsRepository.save(ratings);
        }

        Optional<Ratings> ratings = ratingsRepository.findByUserIdAndRecipeId(
                ratingsDto.getUserId(), ratingsDto.getRecipeId()
        );

        @NotNull Double previousMark = ratings.get().getScore();

        /*
        * If we have @previousMark == new value of score
        * we just remove info about voting from this user
        *
        * UPD: like in YouTube
        * */
        if(previousMark.equals(ratingsDto.getScore())) {
            ratingsRepository.deleteById(
                    new RatingsId(ratingsDto.getUserId(), ratingsDto.getRecipeId()));
            recipeRepository.removeVote(previousMark, ratingsDto.getRecipeId());
            return Ratings.builder().build();
        }

        recipeRepository.revote(previousMark, ratingsDto.getScore(), ratingsDto.getRecipeId());
        return ratingsRepository.save(modelMapper.map(ratingsDto, Ratings.class));
    }

    /*
    * @recipeId   which recipe we update
    * @score      new score that we set
    * @userId     check if the user already marked it
    * */
// TODO check if we can get id of recipe and than send it back
// TODO We should know if the user marked Recipe before

//        --------------------------------------
//        TODO need also table where we will have:
//        - userId
//        - recipeId
//        these fields should be a key
//        --------------------------------------
}

//package com.example.easymeals.service;
//
//import com.example.easymeals.dataprovider.dto.RatingDto;
//import com.example.easymeals.entity.Rating;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class RatingServiceImpl implements RatingService {
//
//    private final RatingRepository ratingRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public Rating create(RatingDto ratingDto) {
//        Rating rating = modelMapper.map(ratingDto, Rating.class);
//        return ratingRepository.save(rating);
//    }
//    /*
//    * @recipeId   which recipe we update
//    * @score      new score that we set
//    * @userId     check if the user already marked it
//    * */
//// TODO check if we can get id of recipe and than send it back
//// TODO We should know if the user marked Recipe before
//    @Override
//    public Optional<Rating> update(Long recipeId, Double score) {
//        if(!ratingRepository.existsById(recipeId)) {
//            create(RatingDto.builder()
//                    .recipeId(recipeId)
//                    .build());
//        }
//
////        --------------------------------------
////        TODO need also table where we will have:
////        - userId
////        - recipeId
////        these fields should be a key
////        --------------------------------------
//
//        Rating ratingOldValue = ratingRepository.getById(recipeId);
////        Rating newRatingValue = Rating.builder()
////                .recipeId(recipeId)
////                .numberOfVotes()
////                .build();
//        return Optional.empty();
//    }
//
//}

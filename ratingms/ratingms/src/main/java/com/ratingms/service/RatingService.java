package com.ratingms.service;

import com.ratingms.entity.Ratings;

import java.util.List;

public interface RatingService {
    //create
    Ratings create(Ratings ratings);
    List<Ratings> getRatings();
    Ratings getRatingById(int ratingId);
    Ratings updateRating(Ratings ratings, int ratingId);
    String deleteRating(int ratingId);




}

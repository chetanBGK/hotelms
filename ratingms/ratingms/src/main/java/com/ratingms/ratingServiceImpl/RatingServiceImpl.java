package com.ratingms.ratingServiceImpl;

import com.ratingms.entity.Ratings;
import com.ratingms.exception.ResourceNotFoundException;
import com.ratingms.repository.RatingRepo;
import com.ratingms.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingRepo ratingRepo;

    public RatingServiceImpl(RatingRepo ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @Override
    public Ratings create(Ratings ratings) {
        return ratingRepo.save(ratings);
    }

    @Override
    public List<Ratings> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public Ratings getRatingById(int ratingId) {
        return ratingRepo.findById(ratingId)
                .orElseThrow(()-> new ResourceNotFoundException("Record not found with id"+ratingId));
    }

    @Override
    public Ratings updateRating(Ratings ratings, int ratingId) {
        Ratings ratings1 = ratingRepo.findById(ratingId)
                .orElseThrow(()-> new ResourceNotFoundException("Record not found with id"+ratingId));
        ratings1.setRating(ratings.getRating());
        ratings1.setFeedback(ratings.getFeedback());
        return ratingRepo.save(ratings1);


    }

    @Override
    public String deleteRating(int ratingId) {
        if (ratingRepo.existsById(ratingId))
        return "Rating deleted successfully";
        else
            throw new ResourceNotFoundException("Record not found with id"+ratingId);
    }
}

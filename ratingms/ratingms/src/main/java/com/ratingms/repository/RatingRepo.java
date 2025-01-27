package com.ratingms.repository;

import com.ratingms.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Ratings, Integer> {

    List<Ratings> findByUserId(int userId);
    List<Ratings> findByHotelId(int hotelId);
}

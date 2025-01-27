package com.ratingms.repository;

import com.ratingms.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepo extends JpaRepository<Ratings, Integer> {
}

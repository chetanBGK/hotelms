package com.ratingms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;
    private int userId;
    private int hotelId;
    private String feedback;
    private int rating;
}

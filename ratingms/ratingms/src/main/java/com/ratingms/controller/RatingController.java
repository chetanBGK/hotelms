package com.ratingms.controller;

import com.ratingms.entity.Ratings;
import com.ratingms.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("createrating")
    public Ratings createRating(@RequestBody Ratings ratings){
        return ratingService.create(ratings);
    }

    @GetMapping("getallrating")
    public List<Ratings> getAllRating(){
        return ratingService.getRatings();
    }

    @GetMapping("getratingbyid/{id}")
    public ResponseEntity<Ratings> getRatingById(@PathVariable int id){
        return new ResponseEntity<>(ratingService.getRatingById(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Ratings> updateRating(@RequestBody Ratings ratings, @PathVariable int id){
        return new ResponseEntity<>(ratingService.updateRating(ratings, id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable int id){
        return new ResponseEntity<>(ratingService.deleteRating(id), HttpStatus.OK);
    }

    @GetMapping("getratingbyuserid/{userId}")
    public ResponseEntity<List<Ratings>> getRatingByUserId(@PathVariable int userId){
        return new ResponseEntity<>(ratingService.getRatingByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("getratingbyhotelid/{hotelId}")
    public ResponseEntity<List<Ratings>> getRatingByHotelId(@PathVariable int hotelId){
        return new ResponseEntity<>(ratingService.getRatingByHotelId(hotelId), HttpStatus.OK);
    }

    @PostMapping("saveallratings")
    public ResponseEntity<List<Ratings>> saveAllRatings(@RequestBody List<Ratings> ratings){
        return new ResponseEntity<>(ratingService.saveAllRatings(ratings), HttpStatus.OK);
    }

}

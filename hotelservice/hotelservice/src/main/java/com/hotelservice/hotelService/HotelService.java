package com.hotelservice.hotelService;

import com.hotelservice.dto.HotelWithRatingDto;
import com.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService{
    Hotel getHotelById(int id);
    Hotel saveHotel(Hotel hotel);
    List<HotelWithRatingDto> getAllHotels();
    void deleteHotel(int id);
    Hotel updateHotel(Hotel hotel,int id);


}

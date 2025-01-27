package com.hotelservice.hotelService;

import com.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService{
    Hotel getHotelById(int id);
    Hotel saveHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    void deleteHotel(int id);
    Hotel updateHotel(Hotel hotel,int id);


}

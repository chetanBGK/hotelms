package com.hotelservice.hotelServiceImpl;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.hotelRepo.HotelRepo;
import com.hotelservice.hotelService.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepo hotelRepo;

    public HotelServiceImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Record not found with id"+id));
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {

        return hotelRepo.findAll();
    }

    @Override
    public void deleteHotel(int id) {
        if (hotelRepo.existsById(id))
            hotelRepo.deleteById(id);
        else
            throw new ResourceNotFoundException("Record not found with id"+id);
    }

    @Override
    public Hotel updateHotel(Hotel hotel, int id) {
    Hotel hotel1 = hotelRepo.findById(id)
            .orElseThrow(()->new ResourceNotFoundException("Record not found with id"+id));
    hotel1.setName(hotel.getName());
    hotel1.setLocation(hotel.getLocation());
    hotel1.setAbout(hotel.getAbout());
    return hotelRepo.save(hotel1);
    }
}

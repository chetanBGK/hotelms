package com.hotelservice.hotelServiceImpl;

import com.hotelservice.dto.HotelWithRatingDto;
import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.external.Ratings;
import com.hotelservice.external.User;
import com.hotelservice.hotelRepo.HotelRepo;
import com.hotelservice.hotelService.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private RestTemplate restTemplate;

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
    public List<HotelWithRatingDto> getAllHotels() {

        List<Hotel> hotels = hotelRepo.findAll();
        List<HotelWithRatingDto> hotelWithRatingDtos = new ArrayList<>();

//        RestTemplate restTemplate = new RestTemplate();

        for (Hotel hotel : hotels) {
            HotelWithRatingDto hotelWithRatingDto = new HotelWithRatingDto();
            hotelWithRatingDto.setHotel(hotel);
            Ratings ratings=restTemplate
                    .getForObject("http://RATINGMS:8083/getratingbyid/"+hotel.getRatingId(),Ratings.class);
            hotelWithRatingDto.setRatings(ratings);

            User user=restTemplate
                    .getForObject("http://HOTELMS:8081/api/user/getuser/"+hotel.getUserId(),User.class);
            hotelWithRatingDto.setUser(user);
            hotelWithRatingDtos.add(hotelWithRatingDto);
        }

        return hotelWithRatingDtos;
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

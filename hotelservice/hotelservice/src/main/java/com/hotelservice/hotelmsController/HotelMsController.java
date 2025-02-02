package com.hotelservice.hotelmsController;

import com.hotelservice.dto.HotelWithRatingDto;
import com.hotelservice.entity.Hotel;
import com.hotelservice.hotelService.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelMsController {

    private final HotelService hotelService;


    public HotelMsController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("addhotel")
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotelService.saveHotel(hotel);
    }

    @GetMapping("getallhotel")
    public List<HotelWithRatingDto> getHotel()
    {
        return hotelService.getAllHotels();
    }

    @GetMapping("gethotelbyid/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id)
    {
        return new ResponseEntity<Hotel>(hotelService.getHotelById(id),HttpStatus.OK);
    }

    @PutMapping("updatehotel/{id}")
    public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel,@PathVariable int id)
    {
        return new ResponseEntity<>(hotelService.updateHotel(hotel,id),HttpStatus.OK);
    }

    @DeleteMapping("deletehotel/{id}")
    public String deleteHotel(@PathVariable int id)
    {
        hotelService.deleteHotel(id);

        return "Hotel deleted successfully";
    }


}

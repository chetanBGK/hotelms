package com.hotelservice.hotelRepo;

import com.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel, Integer> {
}

package com.kickoffs.HotelBooking_API.repository;

import com.kickoffs.HotelBooking_API.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    //Add the required annotations to make the Hotel Repository
}

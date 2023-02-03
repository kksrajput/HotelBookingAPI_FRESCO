package com.kickoffs.HotelBooking_API.repository;

import com.kickoffs.HotelBooking_API.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    //Add the required annotations to make the Owner Repository
}

package com.kickoffs.HotelBooking_API.Service;

import com.kickoffs.HotelBooking_API.DTOs.BookingDTO;
import com.kickoffs.HotelBooking_API.models.Room;
import com.kickoffs.HotelBooking_API.repository.HotelRepository;
import com.kickoffs.HotelBooking_API.repository.OwnerRepository;
import com.kickoffs.HotelBooking_API.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RoomService {
    /*
    Implement the business logic for the Room operations in this class
    Make sure to add required annotations
    */
	@Autowired
    private OwnerRepository ownerRepository;
	@Autowired
    private HotelRepository hotelRepository;
	@Autowired
    private RoomRepository roomRepository;

    //to add room object into room repository
    //created->201
    public ResponseEntity<Object> addRoom(Room room) {
    	roomRepository.save(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    //to get rooms in respective with the request parameter passed
    //ok->200
    public ResponseEntity<Object> getRooms(Optional<Integer> hotelId) {
        Room room = roomRepository.findById(hotelId.get()).orElse(null);
    	return ResponseEntity.ok(room);
    }

    //to book a room by updating their occupied field with roomId
    //ok->200
    //not found->404
    public ResponseEntity<Object> bookARoom(int roomId, BookingDTO bookingDTO) {
        bookingDTO.setOccupied(true);
    	return null;
    }

    //remove an unoccupied room from a hotel with roomId
    //ok->200
    //badRequest->400
    public ResponseEntity<Object> deleteARoom(int roomId) {
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.get().isOccupied()) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("room is occupied");
        }
        roomRepository.deleteById(roomId);
    	return ResponseEntity.ok("200 Ok");
    }
}

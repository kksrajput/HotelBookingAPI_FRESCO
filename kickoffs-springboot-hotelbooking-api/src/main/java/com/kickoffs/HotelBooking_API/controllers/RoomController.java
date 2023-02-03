package com.kickoffs.HotelBooking_API.controllers;

import com.kickoffs.HotelBooking_API.DTOs.BookingDTO;
import com.kickoffs.HotelBooking_API.Service.RoomService;
import com.kickoffs.HotelBooking_API.models.Room;
import com.kickoffs.HotelBooking_API.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RoomController {

    /*
    This controller would be responsible for the Room endpoints
    Add the required annotations and create the endpoints
    */
	@Autowired
    public RoomService roomService;
	@Autowired
    public RoomRepository roomRepository;
    
//    @Autowired
//    public RoomController(RoomService roomService) {
//    	this.roomService = roomService;
//    }

    //to add room object into room repository
    @PostMapping("/room/add")
    public ResponseEntity<Object> addRoom(@RequestBody Room room){
    	roomService.addRoom(room);
    	return ResponseEntity.status(HttpStatus.CREATED).body("201 created");
//        return null; 
    }

    //to get the rooms based on request parameter
    @GetMapping("/rooms/get/{id}")
    public ResponseEntity<Object> getRooms(@PathVariable(value = "id") Optional<Integer> hotelId){
        
        return ResponseEntity.ok(roomService.getRooms(hotelId));
    }

  //to get the rooms based on request parameter
    @GetMapping("/rooms/get")
    public ResponseEntity<Object> getRoomsByQuery(@RequestParam Optional<Integer> hotelId){
        
        return ResponseEntity.ok(roomService.getRooms(hotelId));
    }
    //to book the hotel by updating the occupied field
    @PutMapping("/rooms/book/{roomId}")
    public ResponseEntity<Object> bookARoom(@PathVariable(value = "roomId")int roomId, BookingDTO bookingDTO){
        Optional<Room> room = roomRepository.findById(roomId);
        if(room.get() == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No room found");
        }
        if(room.get().isOccupied()) {
        	room.get().setOccupied(false);
        }
        else {
        	room.get().setOccupied(true);
        }
        roomRepository.save(room.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    //remove an unoccupied room from a hotel
    @DeleteMapping("/rooms/delete/{roomId}")
    public ResponseEntity<Object> deleteARoom(int roomId){
    	ResponseEntity<Object> room = roomService.deleteARoom(roomId);
    	return room;
    }

}

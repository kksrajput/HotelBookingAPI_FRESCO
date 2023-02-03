package com.kickoffs.HotelBooking_API.controllers;

import com.kickoffs.HotelBooking_API.DTOs.HotelRequestDTO;
import com.kickoffs.HotelBooking_API.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    /*
    This controller would be responsible for the Hotel endpoints
    Add the required annotations and create the endpoints
    */
	@Autowired
    private HotelService hotelService;

    //to add hotel object into hotel repository
    @PostMapping("/hotel/add")
    public ResponseEntity<Object> addHotel(@RequestBody HotelRequestDTO hotelRequestDTO){
    	hotelService.addHotel(hotelRequestDTO);
    	return ResponseEntity.status(HttpStatus.CREATED).body("201 created");
//    	return null;
    }
}

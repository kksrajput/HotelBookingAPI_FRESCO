package com.kickoffs.HotelBooking_API.Service;


import com.kickoffs.HotelBooking_API.DTOs.HotelRequestDTO;
import com.kickoffs.HotelBooking_API.models.Hotel;
import com.kickoffs.HotelBooking_API.models.Owner;
import com.kickoffs.HotelBooking_API.repository.HotelRepository;
import com.kickoffs.HotelBooking_API.repository.OwnerRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    /*
    Implement the business logic for the Hotel operations in this class
    Make sure to add required annotations
    */
	@Autowired
    private OwnerRepository ownerRepository;
	@Autowired
    private HotelRepository hotelRepository;


    //to add hotel object into hotel repository
    //created->201
    public ResponseEntity<Object> addHotel(HotelRequestDTO hotelRequestDTO) {
    	Optional<Owner> owner = ownerRepository.findById(hotelRequestDTO.getOwnerName());
//    	if()
    	Hotel hotel = new Hotel(1,hotelRequestDTO.getHotelName(),hotelRequestDTO.getAddress(),owner.get());
  
    	hotelRepository.save(hotel);
    	return null;
    }

}

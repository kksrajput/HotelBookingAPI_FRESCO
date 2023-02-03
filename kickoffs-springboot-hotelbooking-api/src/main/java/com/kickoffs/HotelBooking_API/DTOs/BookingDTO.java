package com.kickoffs.HotelBooking_API.DTOs;

public class BookingDTO {

    private Boolean occupied;

    public BookingDTO(){

    }

    public BookingDTO(Boolean occupied) {
        this.occupied = occupied;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }
}

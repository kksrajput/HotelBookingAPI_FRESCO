package com.kickoffs.HotelBooking_API.DTOs;



public class HotelRequestDTO {
    private String hotelName;
    private String address;
    private String ownerName;

    public HotelRequestDTO(){

    }

    public HotelRequestDTO(String hotelName, String address, String ownerName) {
        this.hotelName = hotelName;
        this.address = address;
        this.ownerName = ownerName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}

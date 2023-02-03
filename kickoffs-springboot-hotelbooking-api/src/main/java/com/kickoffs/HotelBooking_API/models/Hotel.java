package com.kickoffs.HotelBooking_API.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String hotelName;
    private String address;

    @ManyToOne
    @JoinColumn(name = "Owner")
    private Owner owner;

    public Hotel() {
    }

    public Hotel(int id, String hotelName, String address, Owner owner) {
        this.id = id;
        this.hotelName = hotelName;
        this.address = address;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Owner getOwner(Optional<Owner> byId) {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", owner=" + owner +
                '}';
    }
}

package com.kickoffs.HotelBooking_API.models;



import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNo;
    private float rentAmount;
    @Column(nullable = true)
    public boolean occupied;
    private int hotelId;

    public Room() {
    }

    public Room(int id, int roomNo, boolean occupied, float rentAmount, int hotelId) {
        this.id = id;
        this.roomNo = roomNo;
        this.occupied = occupied;
        this.rentAmount = rentAmount;
        this.hotelId = hotelId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public float getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(float rentAmount) {
        this.rentAmount = rentAmount;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNo=" + roomNo +
                ", occupied=" + occupied +
                ", rentAmount=" + rentAmount +
                ", hotelId=" + hotelId +
                '}';
    }
}

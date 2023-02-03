package com.kickoffs.HotelBooking_API.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Owner {

    @Id
    private String userName;
    private int age;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "owner",cascade = {CascadeType.ALL})
    private List<Hotel> hotels;

    public Owner() {
    }

    public Owner(String userName, int age, String password, String email, List<Hotel> hotels) {
        this.userName = userName;
        this.age = age;
        this.password = password;
        this.email = email;
        this.hotels = hotels;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", hotels=" + hotels +
                '}';
    }
}

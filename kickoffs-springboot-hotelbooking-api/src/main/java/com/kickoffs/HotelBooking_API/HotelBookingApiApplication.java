package com.kickoffs.HotelBooking_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.kickoffs.HotelBooking_API.Service.RoomService"})
//@EntityScan("com.delivery.domain")
//@EnableJpaRepositories("com.delivery.repository")
public class HotelBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApiApplication.class, args);
	}

}

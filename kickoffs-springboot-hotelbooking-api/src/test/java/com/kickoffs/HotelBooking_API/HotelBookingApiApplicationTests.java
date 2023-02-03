package com.kickoffs.HotelBooking_API;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HotelBookingApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;



	@Test
	@Order(1)
	public void addHotel() throws Exception {
		mockMvc.perform(post("/hotel/add").contentType(MediaType.APPLICATION_JSON)
				.content((addAHotel("akatsukiInn", "28/L leaf village", "madara88").toJSONString())))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.hotelName", containsStringIgnoringCase("akatsukiInn")))
				.andExpect(jsonPath("$.address", containsStringIgnoringCase("28/L leaf village")));

		mockMvc.perform(post("/hotel/add").contentType(MediaType.APPLICATION_JSON)
				.content((addAHotel("hotelLotus", "25/L lotus village", "Jhon dew").toJSONString())))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.hotelName", containsStringIgnoringCase("hotelLotus")))
				.andExpect(jsonPath("$.address", containsStringIgnoringCase("25/L lotus village")));
	}

	@Test
	@Order(2)
	public void addRoom() throws Exception {
		mockMvc.perform(post("/room/add").contentType(MediaType.APPLICATION_JSON)
				.content((addARoom(101, 2500, 1).toJSONString())))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.roomNo", is(101)))
				.andExpect(jsonPath("$.rentAmount", is(2500.0)))
				.andExpect(jsonPath("$.occupied", is(false)))
				.andExpect(jsonPath("$.hotelId", is(1)));

		mockMvc.perform(post("/room/add").contentType(MediaType.APPLICATION_JSON)
				.content((addARoom(201, 9000, 2).toJSONString())))
				.andExpect(MockMvcResultMatchers.status().is(201))
				.andExpect(jsonPath("$.id", is(2)))
				.andExpect(jsonPath("$.roomNo", is(201)))
				.andExpect(jsonPath("$.rentAmount", is(9000.0)))
				.andExpect(jsonPath("$.occupied", is(false)))
				.andExpect(jsonPath("$.hotelId", is(2)));

	}


	@Test
	@Order(3)
	public void getRooms() throws Exception {
		mockMvc.perform(get("/rooms/get")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.[0].id", is(1)))
				.andExpect(jsonPath("$.[0].roomNo", is(101)))
				.andExpect(jsonPath("$.[0].rentAmount", is(2500.0)))
				.andExpect(jsonPath("$.[0].occupied", is(false)))
				.andExpect(jsonPath("$.[0].hotelId", is(1)))
				.andExpect(jsonPath("$.[1].id", is(2)))
				.andExpect(jsonPath("$.[1].roomNo", is(201)))
				.andExpect(jsonPath("$.[1].rentAmount", is(9000.0)))
				.andExpect(jsonPath("$.[1].occupied", is(false)))
				.andExpect(jsonPath("$.[1].hotelId", is(2)));
	}

	@Test
	@Order(4)
	public void getRoomsWithHotelId() throws Exception {
		mockMvc.perform(get("/rooms/get").param("hotelId","2")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.[0].id", is(2)))
				.andExpect(jsonPath("$.[0].roomNo", is(201)))
				.andExpect(jsonPath("$.[0].rentAmount", is(9000.0)))
				.andExpect(jsonPath("$.[0].occupied", is(false)))
				.andExpect(jsonPath("$.[0].hotelId", is(2)));
	}

	@Test
	@Order(5)
	public void BookARoom() throws Exception {
		mockMvc.perform(put("/rooms/book/1").contentType(MediaType.APPLICATION_JSON)
				.content((updateRoom(true).toJSONString())))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.roomNo", is(101)))
				.andExpect(jsonPath("$.rentAmount", is(2500.0)))
				.andExpect(jsonPath("$.occupied", is(true)))
				.andExpect(jsonPath("$.hotelId", is(1)));
	}


	@Test
	@Order(6)
	public void deleteRoom() throws Exception {
		mockMvc.perform(delete("/rooms/delete/1")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().is(400))
				.andExpect(jsonPath("$.msg", containsStringIgnoringCase("room is occupied")));

		mockMvc.perform(delete("/rooms/delete/2")
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().is(200));
	}


	public JSONObject addAOwner(String userName, String password, int age, String email){
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("userName", userName);
		map.put("password", password);
		map.put("age", age);
		map.put("email", email);
		return new JSONObject(map);
	}

	public JSONObject addAHotel(String hotelName, String address, String ownerName){
		Map<String, Object> map = new LinkedHashMap<>();

		map.put("hotelName", hotelName);
		map.put("address", address);
		map.put("ownerName", ownerName);

		return new JSONObject(map);
	}

	public JSONObject addARoom(int roomNo, float rentAmount, int hotelId){
		Map<String, Object> map = new LinkedHashMap<>();

		map.put("roomNo", roomNo);
		map.put("rentAmount", rentAmount);
		map.put("hotelId", hotelId);

		return new JSONObject(map);
	}

	public JSONObject updateRoom(Boolean occupied){
		Map<String, Object> map = new LinkedHashMap<>();

		map.put("occupied", occupied);

		return new JSONObject(map);
	}

}

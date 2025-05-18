package com.saar.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saar.hotel.entity.Hotel;
import com.saar.hotel.server.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/add")
	public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel)
	{
		Hotel addedHotel=hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedHotel);
	}
	@PutMapping("/update/{hotelId}")
	public ResponseEntity<Hotel>updateHotel(@PathVariable String hotelId, @RequestBody Hotel hotel)
	{
		Hotel updatedHotel=hotelService.updateHotel(hotelId,hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedHotel);
	}
	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<String>deleteHotel(@PathVariable String hotelId)
	{
		String msg=hotelService.deleteHotel(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(msg);
	}
	@GetMapping("/get/{hotelId}")
	public ResponseEntity<Hotel>getHotel(@PathVariable String hotelId)
	{
		Hotel hotel=hotelService.getHotel(hotelId);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<Hotel>>getAllHotel()
	{
		List<Hotel> hotels=hotelService.getAllHotel();
		return ResponseEntity.status(HttpStatus.CREATED).body(hotels);
	}

}

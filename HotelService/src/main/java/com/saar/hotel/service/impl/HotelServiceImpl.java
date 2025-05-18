package com.saar.hotel.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.hotel.entity.Hotel;
import com.saar.hotel.exception.ResourceNotFoundException;
import com.saar.hotel.repositories.HotelRepository;
import com.saar.hotel.server.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
     @Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setHotelId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(String hotelId, Hotel hotel) {
		Hotel newHotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel is not found with id : "+hotelId));
		return hotelRepository.save(hotel);
	}

	@Override
	public String deleteHotel(String hotelId) {
		Hotel hotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel is not found with id : "+hotelId));
		hotelRepository.delete(hotel);
		return "Hotel is deleted with id :"+hotelId;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		Hotel newHotel=hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundException("Hotel is not found with id : "+hotelId));
		return newHotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		List<Hotel>hotels=hotelRepository.findAll();
		return hotels;
	}

}

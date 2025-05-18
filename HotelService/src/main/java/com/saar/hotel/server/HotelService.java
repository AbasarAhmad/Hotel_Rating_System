package com.saar.hotel.server;

import java.util.List;

import com.saar.hotel.entity.Hotel;

public interface HotelService {
	Hotel createHotel(Hotel hotel);
	Hotel updateHotel(String hotelId, Hotel hotel);
	String deleteHotel(String hotelId);
	Hotel getHotel(String hotelId);
	List<Hotel> getAllHotel();

}

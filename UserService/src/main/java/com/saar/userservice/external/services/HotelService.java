package com.saar.userservice.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.saar.userservice.entity.Hotel;

@FeignClient(name="HOTELSERVICE")
public interface HotelService 
{
	@GetMapping("/hotels/get/{hotelId}")
	 Hotel  getHotel(@PathVariable("hotelId") String hotelId);
}

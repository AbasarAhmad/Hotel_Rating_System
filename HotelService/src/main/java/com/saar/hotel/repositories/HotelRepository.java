package com.saar.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saar.hotel.entity.Hotel;

@Repository
public interface HotelRepository  extends JpaRepository<Hotel, String>{

}

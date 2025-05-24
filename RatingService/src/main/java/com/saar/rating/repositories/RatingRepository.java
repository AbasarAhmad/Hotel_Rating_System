package com.saar.rating.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.saar.rating.entity.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String>{

	//Custom finder methods
	
	List<Rating>findByUserId(String userId);
	List<Rating>findByHotelId(String hotelId);
}

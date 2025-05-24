package com.saar.rating.service;

import java.util.List;

import com.saar.rating.entity.Rating;

public interface RatingService {
	Rating createRating(Rating rating);
	Rating updateRating(String ratingId , Rating rating);
	String deleteRating(String ratingId);
	Rating getRating(String ratingId);
	List<Rating>getAllRating();
	List<Rating>getAllRatingByUserId(String userId);
	List<Rating>getAllRatingByHotelId(String hotelId);

}

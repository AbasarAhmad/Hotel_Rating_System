package com.saar.rating.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saar.rating.entity.Rating;
import com.saar.rating.exception.ResourceNotFoundException;
import com.saar.rating.repositories.RatingRepository;
import com.saar.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepository ratingRepository ;
	
	@Override
	public Rating createRating(Rating rating) {
		String id=UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepository.save(rating);
	}

	@Override
	public Rating updateRating(String ratingId, Rating rating) {
		Rating rg=ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating is not Find with Id : "+ratingId ));
		return ratingRepository.save(rating);
	}

	@Override
	public String deleteRating(String ratingId) {
		Rating rg=ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating is not Find with Id : "+ratingId ));
		ratingRepository.delete(rg);
		return "Rating is delete with id :"+ratingId;
	}

	@Override
	public Rating getRating(String ratingId) {
		Rating rg=ratingRepository.findById(ratingId).orElseThrow(()->new ResourceNotFoundException("Rating is not Find with Id : "+ratingId ));
		return rg;
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}

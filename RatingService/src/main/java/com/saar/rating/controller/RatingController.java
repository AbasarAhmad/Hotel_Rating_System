package com.saar.rating.controller;

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

import com.saar.rating.entity.Rating;
import com.saar.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/add")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	
	@PutMapping("/update/{ratingId}")
	public ResponseEntity<Rating> updateRating( @PathVariable String ratingId,@RequestBody Rating rating)
	{
		return ResponseEntity.ok().body(ratingService.updateRating(ratingId, rating));
	}
	
	
	@DeleteMapping("delete/{ratingId}")
	public ResponseEntity<String> deleteRating(@PathVariable String ratingId)
	{
		String msg= ratingService.deleteRating(ratingId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT) // 204 No Content
                .body(msg);
	}
	
	
	@GetMapping("/get/{ratingId}")
	public ResponseEntity<Rating> getRating(@PathVariable String ratingId)
	{
		return ResponseEntity.ok(ratingService.getRating(ratingId));
	}
	
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	
	@GetMapping("/get/userId/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingByUserId(userId));
	}
	
	
	@GetMapping("/get/hotelId/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingByHotelId(hotelId));
	}
	

}

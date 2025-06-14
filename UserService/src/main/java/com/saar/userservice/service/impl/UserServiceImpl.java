package com.saar.userservice.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saar.userservice.entity.Hotel;
import com.saar.userservice.entity.Rating;
import com.saar.userservice.entity.User;
import com.saar.userservice.exception.ResourceNotFoundException;
import com.saar.userservice.external.services.HotelService;
import com.saar.userservice.repositories.UserRepository;
import com.saar.userservice.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Override
	public User createUser(User user) {
		String randomUserId=UUID.randomUUID().toString(); // Here we are creating a Random and Unique user Id 
		user.setUserId(randomUserId);               // Here setting the random User Id
		return userRepository.save(user);
	}

	@Override
	public User updateUser(String userId, User user) {
		User newUser=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not  found on server : "+userId));
		return userRepository.save(user);
	}

	@Override
	public String deleteUser(String userId) {
		User newUser=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not  found on server : "+userId));
		 userRepository.delete(newUser);
		 return "User is deleted by id : "+userId;
	}
	
	

	@Override
	public User getUser(String userId) {
		User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given id is not  found on server : "+userId));
		
		//fetch ratings from Ratings from RatingService for this userId
		//http://localhost:8082/ratings/get/userId/b2b1368e-88c9-42f9-9054-4735a079a7af
		String ratingUrl="http://RATINGSERVICE/ratings/get/userId/"+user.getUserId();
		
		//getForObject(...) ==> This method sends an HTTP GET request and converts the response body into a Java object.
		Rating[] ratingsOfUser= restTemplate.getForObject(ratingUrl, Rating[].class);
		logger.info("Ratings=========>",ratingsOfUser);
		
		List<Rating>ratings= Arrays.stream(ratingsOfUser).toList();
		/* ======NOTE======
		 * ham getForObject ka use and getForEntity dono ka use kr sakte hai but jab ham getForEntity ka use krte hai to ham
		 * response ka status code bhi fetch kr sakte hai
		 * */
		List<Rating> ratingList = ratings.stream().map(rating ->{
			
			// api call a hotelService to get the hotel
			
			/*
			//http://localhost:8081/hotels/get/728f8f7b-40fc-44b0-a5f2-90de71b095ef
			String hotelUrl = "http://HOTELSERVICE/hotels/get/" + rating.getHotelId();
			ResponseEntity<Hotel> response = restTemplate.getForEntity(hotelUrl, Hotel.class);
			
			//.getForEntity(...)
			//This method performs an HTTP GET request just like .getForObject().
			//But instead of returning just the body, it returns a full ResponseEntity<T>.
			Hotel hotel = response.getBody();
			logger.info("response status code:  ===================================> ", response.getStatusCode());
			
			*/
			//=============OR=========
			
			Hotel hotel = hotelService.getHotel(rating.getHotelId());	
			
			// set the hotel to rating
			rating.setHotel(hotel);
//			return the rating
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		return user;
	}

	@Override
	public List<User> getAllUser() {
			return userRepository.findAll();
	}

}

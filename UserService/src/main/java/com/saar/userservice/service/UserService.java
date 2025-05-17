package com.saar.userservice.service;

import java.util.List;

import com.saar.userservice.entity.User;

public interface UserService {
	User createUser(User user);
	User updateUser(String userId,User user);
	String deleteUser(String userId);
	User getUser(String userId);
	List<User>getAllUser();
}

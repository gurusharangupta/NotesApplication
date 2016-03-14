package com.got.service;

import com.got.model.User;

public interface UserService {
	
	public User checkUser(User user);
	public void updateTimeForUser(User user);
	
}

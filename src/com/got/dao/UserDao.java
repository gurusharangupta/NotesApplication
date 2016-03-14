package com.got.dao;

import com.got.model.User;

public interface UserDao {
	
	public User checkUser(User user);
	public void updateTimeForUser(User user);

}

package com.got.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.got.dao.UserDao;
import com.got.model.User;
import com.got.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao){
		
		this.userDao = userDao;
	}
	
	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}

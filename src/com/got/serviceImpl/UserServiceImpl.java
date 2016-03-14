package com.got.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.got.constant.AppllcationConstant;
import com.got.dao.UserDao;
import com.got.exception.DataNotFoundException;
import com.got.model.User;
import com.got.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService,AppllcationConstant{

	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao){
		
		this.userDao = userDao;
	}
	
	@Override
	public User checkUser(User user) {
		User userObj = userDao.checkUser(user);
		if(userObj!=null && userObj.getPassword().equals(user.getPassword())) {
			return userObj;
		}else {

			throw new DataNotFoundException(USER_NOT_FOUND);
		}
	}
	
	public void updateTimeForUser(User user){
		
		
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}

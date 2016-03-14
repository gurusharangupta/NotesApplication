package com.got.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.got.dao.UserDao;
import com.got.model.User;


@Repository
public class UserDaoImpl implements UserDao {

private SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory){
		
		this.setSessionFactory(sessionFactory);
		
	}
	
	
	
	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

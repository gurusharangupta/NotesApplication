package com.got.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.got.constant.AppllcationConstant;
import com.got.dao.UserDao;
import com.got.model.User;


@Repository
public class UserDaoImpl implements UserDao,AppllcationConstant {

private SessionFactory sessionFactory;
	
	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory){
		
		this.setSessionFactory(sessionFactory);
		
	}
	
	
	
	@Override
	public User checkUser(User user) {
		Query query =  getSessionFactory().getCurrentSession().createQuery("from User where emailId=?");
		query.setString(0, user.getEmailId());
		 List<User> list =  query.list();
		 if(!list.isEmpty()){
			 return list.get(0);
		 }else{
			 return null;
		 }
		
	}
	
	@Override
	public void updateTimeForUser(User user){
		
		
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}

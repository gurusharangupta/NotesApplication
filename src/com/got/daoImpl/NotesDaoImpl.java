package com.got.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.got.dao.NotesDao;
import com.got.model.Notes;
import com.got.model.User;

@Repository
@Transactional
public class NotesDaoImpl implements NotesDao{

	
	private SessionFactory sessionFactory;
	
	@Autowired
	public NotesDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
		
	}
	
	@Override
	public String addNote(Notes note) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String updateNote(Notes note) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String deleteNote(Notes note) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Notes> getNotesForUser(User user) {
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

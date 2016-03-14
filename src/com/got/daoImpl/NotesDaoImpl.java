package com.got.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.got.constant.AppllcationConstant;
import com.got.dao.NotesDao;
import com.got.exception.DataNotFoundException;
import com.got.model.Notes;
import com.got.model.User;

@Repository
@Transactional
public class NotesDaoImpl implements NotesDao,AppllcationConstant{

	
	private SessionFactory sessionFactory;
	
	@Autowired
	public NotesDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
		
	}
	
	@Override
	public String addNote(Notes note) {
	
		getSessionFactory().getCurrentSession().save(note);
		
		return NOTE_SAVE_SUCCESSFUL;
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
		@SuppressWarnings("unchecked")
		Query query =  getSessionFactory().getCurrentSession().createQuery("from Notes where notesUser = ?");
		query.setEntity(0, user);
		List<Notes> notesList = (List<Notes>)query.list();
		if(notesList.isEmpty()){
			throw new DataNotFoundException(NOTE_NOT_FOUND);
		}
	return notesList;
	}

	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	
}

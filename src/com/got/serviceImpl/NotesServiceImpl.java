package com.got.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.got.dao.NotesDao;
import com.got.model.Notes;
import com.got.service.NotesService;

@Service
@Transactional
public class NotesServiceImpl implements NotesService{

	private NotesDao notesDao;
	
	@Autowired
	public NotesServiceImpl(NotesDao notesDao){
		
		this.notesDao = notesDao;
	}
	@Override
	public String addNote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateNote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteNote() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Notes> getNotesForUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public NotesDao getNotesDao() {
		return notesDao;
	}

	public void setNotesDao(NotesDao notesDao) {
		this.notesDao = notesDao;
	}

}

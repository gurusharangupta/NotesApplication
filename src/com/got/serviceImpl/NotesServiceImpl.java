package com.got.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.got.constant.AppllcationConstant;
import com.got.dao.NotesDao;
import com.got.model.Notes;
import com.got.model.User;
import com.got.service.NotesService;

@Service
@Transactional(rollbackFor=Throwable.class,readOnly=false)
public class NotesServiceImpl implements NotesService,AppllcationConstant{

	private NotesDao notesDao;
	
	@Autowired
	public NotesServiceImpl(NotesDao notesDao){
		
		this.notesDao = notesDao;
	}
	
	
	@Override
	public String addNote(Notes note) {
		checkNoteSize(note);
		Date date = new Date();
		note.setCreateTime(date);
		note.setUpdateTime(date);
		note.getNotesUser().setUpdateTime(date);
		//update user time
		return notesDao.addNote(note);
	}

	private void checkNoteSize(Notes note) {
		
		if(note.getTitle().length()>50 || note.getNote().length()>1000){
			throw new RuntimeException(NOTE_SIZE_CONSTRAINT);
		}
		
	}


	@Override
	public String updateNote(Notes note) {
		checkNoteSize(note);
		Date date = new Date();
		note.setUpdateTime(date);
		return notesDao.updateNote(note);
	}

	@Override
	public String deleteNote(Notes note) {
		return notesDao.deleteNote(note);
	}

	@Override
	public List<Notes> getNotesForUser(User user) {
		return notesDao.getNotesForUser(user);
	}
	
	
	public NotesDao getNotesDao() {
		return notesDao;
	}

	public void setNotesDao(NotesDao notesDao) {
		this.notesDao = notesDao;
	}

	

}

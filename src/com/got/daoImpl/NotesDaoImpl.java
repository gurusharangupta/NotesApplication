package com.got.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.got.dao.NotesDao;
import com.got.model.Notes;

@Repository
@Transactional
public class NotesDaoImpl implements NotesDao{

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

}

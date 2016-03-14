package com.got.dao;

import java.util.List;

import com.got.model.Notes;

public interface NotesDao {

	public String addNote();
	public String updateNote();
	public String deleteNote();
	public List<Notes> getNotesForUser();
	
}

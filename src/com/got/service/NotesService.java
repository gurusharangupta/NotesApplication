package com.got.service;

import java.util.List;

import com.got.model.Notes;

public interface NotesService {

	public String addNote();
	public String updateNote();
	public String deleteNote();
	public List<Notes> getNotesForUser();
	
}

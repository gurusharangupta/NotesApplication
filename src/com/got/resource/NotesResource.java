package com.got.resource;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.got.service.NotesService;

@Component
@Path("/notes")
public class NotesResource {

	@Autowired
	public NotesService notesService;
	
	
	public String addNote(){
		
		
		return null;
		
		
	}
	

	public NotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}
	
	
}

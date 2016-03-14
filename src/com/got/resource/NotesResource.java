package com.got.resource;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.got.model.Notes;
import com.got.service.NotesService;

@Component
@Path("/notes")
public class NotesResource {

	@Autowired
	public NotesService notesService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNote(Notes note){
		
		Date date = new Date();
		note.setCreateTime(date);
		note.setUpdateTime(date);
		return notesService.addNote(note);
		
		
		
	}
	

	public NotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}
	
	
}

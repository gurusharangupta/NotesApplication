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
import com.got.model.User;
import com.got.service.NotesService;
import com.got.service.UserService;

@Component
@Path("/notes")
public class NotesResource {

	@Autowired
	private NotesService notesService;
	
	@Autowired
	private UserService userService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addNote(Notes note){
		User user = note.getNotesUser();
		user = userService.checkUser(user);
		Date date = new Date();
		user.setUpdateTime(date);
		note.setCreateTime(date);
		note.setUpdateTime(date);
		note.setNotesUser(user);
		return notesService.addNote(note);
		
		
		
	}
	

	public NotesService getNotesService() {
		return notesService;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}

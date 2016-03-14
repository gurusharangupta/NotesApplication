package com.got.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

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
	
	@Autowired
	private User user;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNote(Notes note){
	   
		
		note.setNotesUser(user);
		notesService.addNote(note);
		
		return	Response.status(Status.CREATED)
				.entity(note)
				.build();
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotesForUser(){
		List<Notes> notes = null;
		
			
			notes = notesService.getNotesForUser(user);
			return	Response.status(Status.FOUND)
			.entity(notes)
			.build();
		
			
			
		}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateNote(Notes note){
		note.setNotesUser(user);
		notesService.updateNote(note);
			
			return	Response.status(Status.OK)
			.entity(note)
			.build();
		
			
			
		}
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNote(Notes note){
		note.setNotesUser(user);
		notesService.deleteNote(note);
			
			return	Response.status(Status.OK)
			.entity(note)
			.build();
		
			
			
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}

package com.got.resource;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
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
	
	User user = null;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addNote(Notes note){
	    user = note.getNotesUser();
		user = userService.checkUser(user);
		note.setNotesUser(user);
		notesService.addNote(note);
		
		return	Response.status(Status.CREATED)
				.entity(note)
				.build();
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getNotesForUser(@HeaderParam("emailid") String emailId,@HeaderParam("password")String password){
		List<Notes> notes = null;
		user = new User();
		user.setEmailId(emailId);
		user.setPassword(password);
		user= userService.checkUser(user);
		
			
			notes = notesService.getNotesForUser(user);
			return	Response.status(Status.FOUND)
			.entity(notes)
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
	
	
}

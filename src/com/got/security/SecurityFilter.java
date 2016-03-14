package com.got.security;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.got.constant.AppllcationConstant;
import com.got.model.ErrorMessage;
import com.got.model.User;
import com.got.service.UserService;

@Component
@Provider
public class SecurityFilter implements ContainerRequestFilter,AppllcationConstant{

	@Autowired
	private UserService userService;
	
	@Autowired
	private User user;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
	
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZAITON_HEADER_KEY);
		if(authHeader!=null && authHeader.size()>0){
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken);
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			String username = tokenizer.nextToken();
			String password = tokenizer.nextToken();
			
			
			user.setEmailId(username);
			user.setPassword(password);
			userService.checkUser(user);
			return;
			
		}
		ErrorMessage errorMessage = new ErrorMessage("User Cannnot access the resource",401,"http://www.gotprint.com");
		Response unAuthorizedStatus = Response
										.status(Response.Status.UNAUTHORIZED)
										.entity(errorMessage)
										.build();
		requestContext.abortWith(unAuthorizedStatus);
		
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

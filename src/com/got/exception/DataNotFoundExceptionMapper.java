package com.got.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.got.model.ErrorMessage;

@Component
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException ex) {
		
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),404,"http://www.gotprint.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}


}

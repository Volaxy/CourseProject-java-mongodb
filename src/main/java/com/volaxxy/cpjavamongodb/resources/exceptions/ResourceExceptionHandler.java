package com.volaxxy.cpjavamongodb.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.volaxxy.cpjavamongodb.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest httpServletRequest) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(System.currentTimeMillis(), status.value(), "Not Found", error.getMessage(), httpServletRequest.getRequestURI());
		
		return ResponseEntity.status(status).body(standardError);
	}
	
}

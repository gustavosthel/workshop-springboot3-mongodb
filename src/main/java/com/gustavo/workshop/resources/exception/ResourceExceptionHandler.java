package com.gustavo.workshop.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.gustavo.workshop.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardErro err = new StandardErro(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getDescription(false));
		return ResponseEntity.status(status).body(err);
	}
}

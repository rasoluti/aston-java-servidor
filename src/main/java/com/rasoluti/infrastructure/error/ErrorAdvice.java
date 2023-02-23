package com.rasoluti.infrastructure.error;

import java.util.HashMap;
import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ErrorAdvice {

	public ErrorAdvice() {
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ApiError>handlerNoSuchElementException(NoSuchElementException exception, HttpServletRequest request){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
											exception.getMessage(),
											request.getRequestURI()
										);
		return new ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ApiError>handlerEmptyResultDataAccessException(EmptyResultDataAccessException exception, HttpServletRequest request){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
											exception.getMessage(),
											request.getRequestURI()
										);
		return new ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
	} 
	
	@ExceptionHandler(NotFoundEx.class)
	public ResponseEntity<ApiError>handlerNotFoundEx(NotFoundEx exception, HttpServletRequest request){
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND.value(),
											exception.getMessage(),
											request.getRequestURI()
										);
		return new ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
	} 
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError>handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
		
		HashMap<String, String> listErros =  new HashMap<>();
		for (FieldError error : exception.getFieldErrors()) {
			listErros.put(error.getField(), error.getDefaultMessage()) ;
		}
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),"Campos inválidos!",request.getRequestURI());
		apiError.setErros(listErros);
		return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
	} 
	
	
	
	
	
	
	
	
	
	
	
	

}

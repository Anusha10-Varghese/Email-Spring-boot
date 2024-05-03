package com.nci.api.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class MailExceptionHandler {
		
	@ExceptionHandler
	public ModelAndView handleExceptionNoHandlerFoundException(NoHandlerFoundException e){
		
		String errorMessage="The page you are looking for is removed or doesn't exists";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessage, LocalDateTime.now()); 

		return new ModelAndView("error","error",error);
			
	}
	
	@ExceptionHandler
	public ModelAndView handleExceptionMissingServletRequestParameterException(MissingServletRequestParameterException e) {
		
		String errorMessage="Bad request try again after some time";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage, LocalDateTime.now()); 

		return new ModelAndView("error","error",error);

	}
	@ExceptionHandler
	public ModelAndView handleExceptionHttpSessionRequiredException(HttpSessionRequiredException e) {
		String errorMessage="Internal Server Exception processing failed please login and try again";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage, LocalDateTime.now()); 
		
		return new ModelAndView("error","error",error);
		
	}
	
	@ExceptionHandler
	public ModelAndView handleExceptionNumberFormatException(NumberFormatException e){
		
		String errorMessage="Internal Server Exception processing failed";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage, LocalDateTime.now()); 
		
		return new ModelAndView("error","error",error);
			
	}
	
	@ExceptionHandler
	public ModelAndView handleExceptionClassCastException(ClassCastException e){
		
		String errorMessage="Internal Server Exception processing failed";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage, LocalDateTime.now()); 
		
		return new ModelAndView("error","error",error);
		
	}
	
	@ExceptionHandler
	public ModelAndView handleException(NullPointerException e){
		
		String errorMessage="Internal Server Exception processing failed";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage, LocalDateTime.now()); 
		
		return new ModelAndView("error","error",error);
		
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception e){
		
		String errorMessage="Unexpected Internal Server Exception processing failed caused by :";
		
		MailErrorResponse error=new MailErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage+"\n"+e.getMessage(), LocalDateTime.now()); 
		
		return new ModelAndView("error","error",error);
			
	}
	
		
}

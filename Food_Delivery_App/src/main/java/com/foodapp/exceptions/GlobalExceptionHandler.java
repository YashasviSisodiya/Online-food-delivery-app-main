package com.foodapp.exceptions;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.foodapp.authexceptions.AuthorizationException;


@ControllerAdvice
public class GlobalExceptionHandler {
	Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(BillException.class)
	public ResponseEntity<ErrorDetails> billExceptionHandler(BillException be, WebRequest wr){
		logger.error(be.getMessage(), be);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(be.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<ErrorDetails> cartExceptionHandler(CartException ce, WebRequest wr){
		logger.error(ce.getMessage(), ce);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorDetails> categoryExceptionHandler(CategoryException ce, WebRequest wr){
		logger.error(ce.getMessage(), ce);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest wr){
		logger.error(ce.getMessage(), ce);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(ItemException.class)
	public ResponseEntity<ErrorDetails> itemExceptionHandler(ItemException ie, WebRequest wr){
		logger.error(ie.getMessage(), ie);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ie.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ErrorDetails> orderExceptionHandler(OrderException oe, WebRequest wr){
		logger.error(oe.getMessage(), oe);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(oe.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<ErrorDetails> restaurantExceptionHandler(RestaurantException re, WebRequest wr){
		logger.error(re.getMessage(), re);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(re.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<ErrorDetails> authExceptionHandler(AuthorizationException ae , WebRequest wr){
		logger.error(ae.getMessage(), ae);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ae.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> otherExceptionHandler(Exception ex, WebRequest wr){
		logger.error(ex.getMessage(), ex);
		ErrorDetails err = new ErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(ex.getMessage());
		err.setDetails(wr.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

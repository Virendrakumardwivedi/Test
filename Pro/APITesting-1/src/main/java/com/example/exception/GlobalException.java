package com.example.exception;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(EntriesException.class)
	public ResponseEntity<ErrorDeatiles> errorException
	(EntriesException exe,WebRequest req ){
		
		ErrorDeatiles err = new ErrorDeatiles();
		err.setMessage(exe.getMessage());
		err.setTimestamp(LocalDateTime.now());
		err.setDescripation(req.getDescription(false));
		
		return new ResponseEntity<ErrorDeatiles>(err,HttpStatus.BAD_REQUEST);
		
	}

	
	public ResponseEntity<ErrorDeatiles> methodaArgumentExceptionHandller
	(MethodArgumentNotValidException mex,WebRequest req){
		
		String massage = mex.getBindingResult().getFieldError().getDefaultMessage();
		ErrorDeatiles err = new ErrorDeatiles();
		
		return null;
		
	}
		
	}

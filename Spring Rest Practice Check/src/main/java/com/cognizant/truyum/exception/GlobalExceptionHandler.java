package com.cognizant.truyum.exception;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cognizant.truyum.dao.CartEmptyException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(CartEmptyException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleError(Exception ex, HttpServletRequest request) {
		return new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST, ex.getMessage(),
				request.getRequestURI().toString());
	}

}

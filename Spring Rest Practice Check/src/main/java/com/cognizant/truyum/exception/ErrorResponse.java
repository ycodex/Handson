package com.cognizant.truyum.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	private Date timestamp;
	private HttpStatus code;
	private String message;
	private String path;

	public ErrorResponse(Date timestamp, HttpStatus code, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.message = message;
		this.path = path;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

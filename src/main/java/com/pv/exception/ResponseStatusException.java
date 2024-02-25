package com.pv.exception;

public class ResponseStatusException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResponseStatusException() {

	}
	 
	 public ResponseStatusException(String msg) {
		 
		 super(msg);
		}
}

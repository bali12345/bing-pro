package com.bing.exception;


public class SimpleHttpException extends RuntimeException {
	public SimpleHttpException(Throwable cause) {
		super(cause);
	}

	public SimpleHttpException(String message) {
		super(message);
	}

	public SimpleHttpException(String message, Throwable cause) {
		super(message, cause);
	}
}


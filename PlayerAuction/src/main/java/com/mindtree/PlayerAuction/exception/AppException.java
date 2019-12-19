package com.mindtree.PlayerAuction.exception;

public class AppException extends Exception {
	public AppException() {
		super();
	}

	public AppException(String description) {
		super(description);
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	public AppException(String description, Throwable cause) {
		super(description, cause);
	}
}

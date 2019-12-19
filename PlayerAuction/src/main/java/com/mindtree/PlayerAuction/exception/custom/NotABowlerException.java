package com.mindtree.PlayerAuction.exception.custom;

import com.mindtree.PlayerAuction.exception.AppException;

public class NotABowlerException extends AppException {
	public NotABowlerException() {
		super();
	}

	public NotABowlerException(String description) {
		super(description);

	}

	public NotABowlerException(Throwable cause) {
		super(cause);
	}

	public NotABowlerException(String description, Throwable cause) {
		super(description, cause);
	}
}

package com.mindtree.PlayerAuction.exception.custom;

import com.mindtree.PlayerAuction.exception.AppException;

public class InvalidCategoryException extends AppException {
	public InvalidCategoryException() {
		super();
	}

	public InvalidCategoryException(String description) {
		super(description);

	}

	public InvalidCategoryException(Throwable cause) {
		super(cause);
	}

	public InvalidCategoryException(String description, Throwable cause) {
		super(description, cause);
	}
}

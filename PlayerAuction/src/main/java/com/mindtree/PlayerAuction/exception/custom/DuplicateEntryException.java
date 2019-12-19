package com.mindtree.PlayerAuction.exception.custom;

import com.mindtree.PlayerAuction.exception.AppException;

public class DuplicateEntryException extends AppException {
	public DuplicateEntryException() {
		super();
	}

	public DuplicateEntryException(String description) {
		super(description);
	}

	public DuplicateEntryException(Throwable cause) {
		super(cause);
	}

	public DuplicateEntryException(String description, Throwable cause) {
		super(description, cause);
	}
}

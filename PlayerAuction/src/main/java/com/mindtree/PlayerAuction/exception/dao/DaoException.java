package com.mindtree.PlayerAuction.exception.dao;

import com.mindtree.PlayerAuction.exception.AppException;

public class DaoException extends AppException {
	public DaoException() {
		super();
	}

	public DaoException(String description) {
		super(description);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String description, Throwable cause) {
		super(description, cause);
	}
}

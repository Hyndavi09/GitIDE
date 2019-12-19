package com.mindtree.PlayerAuction.exception.custom;

import com.mindtree.PlayerAuction.exception.AppException;

public class NotABatsman extends AppException {
	public NotABatsman() {
		super();
	}

	public NotABatsman(String description) {
		super(description);

	}

	public NotABatsman(Throwable cause) {
		super(cause);
	}

	public NotABatsman(String description, Throwable cause) {
		super(description, cause);
	}
}

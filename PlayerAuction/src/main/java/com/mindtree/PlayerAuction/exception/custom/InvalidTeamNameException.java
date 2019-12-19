package com.mindtree.PlayerAuction.exception.custom;

public class InvalidTeamNameException extends Exception {
	public InvalidTeamNameException() {
		super();
	}

	public InvalidTeamNameException(String description) {
		super(description);
	}

	public InvalidTeamNameException(Throwable cause) {
		super(cause);
	}

	public InvalidTeamNameException(String description, Throwable cause) {
		super(description, cause);
	}
}

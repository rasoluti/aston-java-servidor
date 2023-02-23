package com.rasoluti.infrastructure.error;

public class NotFoundEx extends RuntimeException{

	private static final long serialVersionUID = -5518757058466755080L;

	public NotFoundEx(String message) {
		super(message);
	}

}

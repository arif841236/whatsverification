package com.indusnet.exception;

/**
 * This class for exception and its extends to runtime exception
 */
public class WhatsappException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public WhatsappException() {
	}

	public WhatsappException(String msg) {
		super(msg);
	}
}

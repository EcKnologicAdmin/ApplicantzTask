package com.beta.replyservice;

public class ReplyMessage {

	private final String message;
	private final int statusCode;

	public ReplyMessage(String message, int statusCode) {
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
}
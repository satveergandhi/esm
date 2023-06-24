package com.user.helper;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User is already there! Please try again another username.");
	}
	public UserFoundException(String msg) {
		super(msg);
	}
}

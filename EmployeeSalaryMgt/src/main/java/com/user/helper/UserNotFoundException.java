package com.user.helper;

public class UserNotFoundException extends Exception{
	
	public UserNotFoundException() {
		super("User with this name not found in database!!");
	}
	public UserNotFoundException(String msg) {
		super(msg);
	}

}

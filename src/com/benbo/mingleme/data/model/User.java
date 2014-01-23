package com.benbo.mingleme.data.model;

public class User {

	private String _userName;
	private String _email;
	
	public User(String userName, String email){
		_userName = userName;
		_email = email;
	}
	
	public String getUsername(){
		return _userName;
	}
	
	public String getEmail(){
		return _email;
	}
}

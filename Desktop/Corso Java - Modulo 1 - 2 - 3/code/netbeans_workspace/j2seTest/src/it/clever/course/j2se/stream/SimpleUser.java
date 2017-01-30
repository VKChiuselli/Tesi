package it.clever.course.j2se.stream;

import java.io.Serializable;

public class SimpleUser implements Serializable {
	
	private String username = null;
	private String password = null;
	
		
	public SimpleUser(String usr, String pwd){
		this.username = usr;
		this.password = pwd;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}

package it.clever.course.j2se.stream;

import java.io.Serializable;

public class User implements Serializable {
	
	private String username = null;
	private transient Password password = null;
	
	public User(){
		
	}
		
	public User(String usr, String pwd){
		this.username = usr;
		this.password = new Password(pwd);
	}
	
	
	public String getPassword() {
		if(password != null){
			return password.getPassword();	
		}else{
			return "********";
		}
		
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	class Password {
		
		private String password = null;
		
		public Password(){
			
		}
		
		public Password(String pwd){
			password = pwd;
		}
		
		public String getPassword(){
			return password;
		}
		
	}
	

}

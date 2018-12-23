package com.example.models;

public class LoginCreadentials {

	public String email;
	public String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginCreadentials [email=" + email + ", password=" + password + "]";
	}
	
}

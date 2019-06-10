package com.caps.beans;

public class User {
	private String uid;
	private String uname;
	private String email;
	private String password;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
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
		return "<table border=1px><tr><td>User ID</td><td>User Name</td><td>Email</td></tr>"
				+ "<tr><td>"+uid+"</td><td>"+uname+"</td><td>"+email+"</td></tr><table>";
	}

}

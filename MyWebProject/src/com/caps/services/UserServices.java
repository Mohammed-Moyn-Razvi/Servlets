package com.caps.services;

import com.caps.beans.User;

public interface UserServices {
	boolean createProfile(User u);
	public User login(String user, String passwd);
	public boolean updateEmail(String userid, String email);
	public User searchUser(String userid);
}

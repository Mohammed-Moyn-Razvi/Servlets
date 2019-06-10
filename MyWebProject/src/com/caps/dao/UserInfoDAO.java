package com.caps.dao;

import com.caps.beans.User;

public interface UserInfoDAO {
	public boolean createProfile(User u);
	public User loginServ(String user, String passwd);
}

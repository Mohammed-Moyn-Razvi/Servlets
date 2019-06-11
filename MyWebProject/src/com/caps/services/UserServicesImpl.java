package com.caps.services;

import com.caps.beans.User;
import com.caps.dao.UserDAOJDBCImpl;
import com.caps.dao.UserInfoDAO;

public class UserServicesImpl implements UserServices {

	UserInfoDAO dao = new UserDAOJDBCImpl();
	
	@Override
	public boolean createProfile(User u) {
		return dao.createProfile(u);
	}

	@Override
	public User login(String user, String passwd) {
		return dao.loginServ(user, passwd);
	}

	@Override
	public boolean updateEmail(String userid, String email) {
		return dao.updateEmail(userid, email);
	}

	@Override
	public User searchUser(String userid) {
		return dao.searchServ(userid);
	}

}

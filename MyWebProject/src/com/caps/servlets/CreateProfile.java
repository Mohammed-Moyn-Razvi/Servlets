package com.caps.servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.beans.User;
import com.caps.dao.UserDAOImpl;



@WebServlet("/createProfile")
public class CreateProfile extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("id");
		String username = req.getParameter("name");
		String email = req.getParameter("email");
		String passwd = req.getParameter("pass");

		User u = new User();
		u.setUid(userid);
		u.setUname(username);
		u.setEmail(email);
		u.setPassword(passwd);

		UserDAOImpl ui = new UserDAOImpl();

		boolean b=ui.createProfile(u);

		PrintWriter out = resp.getWriter();


		if(b){
			out.println("Profile Created....");
		}else {
			out.println("Something went Wrong");
		}

	}
}

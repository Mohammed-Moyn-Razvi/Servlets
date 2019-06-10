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

@WebServlet("/loginServ")
public class LoginServ extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String passwd = req.getParameter("password");
		
		UserDAOImpl ui = new UserDAOImpl();
		
		User u = ui.loginServ(userid, passwd);
		PrintWriter out = resp.getWriter();
		if(u!=null) {
			out.println(u);
		}else {
			out.println("Worng Credentials...");
		}
	}
}
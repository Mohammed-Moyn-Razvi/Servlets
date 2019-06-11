package com.caps.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caps.dao.UserDAOJDBCImpl;
import com.caps.services.UserServices;
import com.caps.services.UserServicesImpl;

@WebServlet("/updateServ")
public class UpdateServ extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String userid = req.getParameter("userid");
	String email = req.getParameter("email");
	
	PrintWriter out = resp.getWriter();
	
	UserServices us = new UserServicesImpl();
	
	boolean b = us.updateEmail(userid, email);
	
	if(b) {
		out.println("Profile Updated....");
	}
	else {
		out.println("Something Went Wrong....");
	}
}
}

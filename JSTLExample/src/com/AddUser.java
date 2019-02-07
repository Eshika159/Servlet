package com;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddStrings a=new AddStrings();
		List<String>li=a.getStrings();
		request.setAttribute("user",li);
		RequestDispatcher dis=request.getRequestDispatcher("ReadUser.jsp");
		dis.forward(request, response);
	}


}

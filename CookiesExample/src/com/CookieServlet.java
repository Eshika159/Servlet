package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();	
		//HttpSession ses=request.getSession();
		
		String name=request.getParameter("t1");
		String value=request.getParameter("t2");
		Cookie c=new Cookie(name,value);
		response.addCookie(c);
		//ses.setAttribute(name,value);
		out.println("Cookie added");
		
		RequestDispatcher dis=request.getRequestDispatcher("ShowCookieSer");
		dis.forward(request,response);
		
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.User;
import serviceLayer.UserServiceLayer;

/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out=response.getWriter();
		
		int uid=Integer.parseInt(request.getParameter("t1"));
		String pass=request.getParameter("t2");
		String uname=request.getParameter("t3");
		String city=request.getParameter("t4");
		String country=request.getParameter("t5");
		int age=Integer.parseInt(request.getParameter("t6"));
		
		User user=new User(uid, pass, uname, city, country, age);
		UserServiceLayer usl=new UserServiceLayer();
		String result=usl.addUser(user);
		
		if(result.equals("Success"))
		{
			request.setAttribute("msg","Successfully Registered");
			RequestDispatcher dis=request.getRequestDispatcher("Welcome.jsp");
			dis.forward(request, response);
		}
		
		
	}

}

package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		String header=getServletContext().getInitParameter("abc");
		HttpSession ses=request.getSession();
		ServletContext ctx=getServletContext();
		//String color=getServletConfig().getInitParameter("color");
		//taking the requested data from user
		out.println("<html><body>");
		out.print("<h2>"+header+" "+request.getAttribute("msg")+" "+ses.getAttribute("Color")+"</h1>");
		
		//This line returns null on user because new request response object
		//out.println("<hr><h1>Welcome to Login servlet "+request.getParameter("user")+"</h1>");
		
		//out.println("<h1> <br>"+request.getParameter("user")+"<br>"+request.getParameter("gender")+"<br>"+request.getParameter("Degree")+"</h1>");
		//out.println("Current time : "+new Date()+" " +initcount+" "+sercount+" "+request.getParameter("t1"));
		out.println("</body></html>");
	}

}

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ServletPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init()
  {		
		
		String driver=getServletContext().getInitParameter("driver");
		String url=getServletContext().getInitParameter("url");
		String user=getServletContext().getInitParameter("user");
		String pass=getServletContext().getInitParameter("pass");
		
	  try {
		  Class.forName(driver);
		con=DriverManager.getConnection(url,user,pass);
		System.out.println("Connected");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get paramtervalues when checkbox is used
			
		PrintWriter out=response.getWriter();
		//context for all
		String header=getServletContext().getInitParameter("abc");
		String color=getServletConfig().getInitParameter("color");
		
		
		//taking the requested data from user
		
		//Dont want business logic to be written in servlet make another class for validation
	
		/*out.println( request.getMethod());
		out.println( request.getHeader("USER-AGENT"));
		out.println("<html><body bgcolor="+color+">");
		out.print("<h1>"+header+"</h1>");
		out.println("<hr><h1>Welcome to my first servlet</h1>");
		out.println("<h1> <br>"+request.getParameter("user")+"<br>"+request.getParameter("gender")+"<br>"+request.getParameter("Degree")+"</h1>");
	*/	
		
		HttpSession ses=request.getSession();
		ServletContext ctx=getServletContext();
		
		String res=null;
		if(request.getParameter("user").equals("Eshika")&& request.getParameter("pass").equals("123"))
		{	res="Success";
			ses.setAttribute("Color","blue");
			ctx.setAttribute("Id","ym071");
			request.setAttribute("msg",res);
			
			//response.sendRedirect("Login");
			
			RequestDispatcher rd=request.getRequestDispatcher("Login");
					rd.forward(request, response);	}
		else
		{
			res="invalid";
			request.setAttribute("msg",res);
			RequestDispatcher rd=request.getRequestDispatcher("yamaha");
			rd.forward(request, response);

		}
		
		
		//out.println("Current time : "+new Date()+" " +initcount+" "+sercount+" "+request.getParameter("t1"));
		out.println("</body></html>");
	}

}

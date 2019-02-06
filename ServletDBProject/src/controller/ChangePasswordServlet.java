package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serviceLayer.UserServiceLayer;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int uid=Integer.parseInt(request.getParameter("t1"));
			String newPass=request.getParameter("t2");
			String oldPass=request.getParameter("t3");
			UserServiceLayer usl=new UserServiceLayer();
			String result=usl.changePassword(uid, newPass, oldPass);
			if(result.equals("success"))
			{	
				request.setAttribute("m","Successfully changed Password");
				RequestDispatcher dis=request.getRequestDispatcher("ChangePassword.jsp");
				dis.include(request, response);
			}
			else
			{
				request.setAttribute("m","Wrong Password entered");
				RequestDispatcher dis=request.getRequestDispatcher("ChangePassword.jsp");
				dis.include(request, response);
			
			}
			
	}

}

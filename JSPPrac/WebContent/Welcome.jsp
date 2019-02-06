<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page errorPage="Error.jsp" %>
    <%@ page import="com.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int count;
public int getcount(){
	return count++;
	
}

%>
<%-- <h2>Current date=<%= new Date()%></h2>
<h3>Count <%= 10/0 %> </h3>
 --%>
<jsp:useBean id="e" class="com.Employee" scope="request"></jsp:useBean>
<%-- <jsp:setProperty property="name" name="e" value="Eshika"/>
 --%><%-- <h2>Name= <jsp:getProperty property="name" name="e"/> </h2>
 --%>
 
 <jsp:setProperty property="*" name="e"/>
<h2>Name: <jsp:getProperty property="name" name="e"/></h2>
<h2>id:<jsp:getProperty property="id" name="e"/></h2>
</body>
</html>
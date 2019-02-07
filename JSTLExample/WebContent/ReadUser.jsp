<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- <c:forEach var="usr" items="${user}">
${usr}
</c:forEach> --%>

<s:setDataSource var="ds" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test" user="root" password="root"/>
<s:query var="result" dataSource="${ds}" >
select * from user;
</s:query>
<c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.Uid}"/></td>
               <td> <c:out value = "${row.Pass}"/></td>
               <td> <c:out value = "${row.UName}"/></td>
               <td> <c:out value = "${row.city}"/></td>
                <td> <c:out value = "${row.country}"/></td>
                 <td> <c:out value = "${row.age}"/></td>
            </tr>
         </c:forEach>

</body>
</html>

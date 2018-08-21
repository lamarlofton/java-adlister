<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: lamarlofton
  Date: 8/20/18
  Time: 12:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

    try {
        if (request.getParameter("username").equals("admin") && request.getParameter("password").equals("Password")) {
    //        session.setAttribute("username", userName);
            response.sendRedirect("profile.jsp");
        }
        else
            response.sendRedirect("Error.jsp");
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <jsp:include page="home.jsp">
        <jsp:param name="title" value="Please login"/>
    </jsp:include>
    <title>Using Forms</title>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
    <h1>Using Forms</h1>
    <form name="Login" action="login.jsp" method="post">
    <table border="0">
        <tbody>
        <tr>
            <td>Username :</td>
            <td><input type="text" name="username" value="" size="50"/></td>
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="text" name="password" value="" size="50"/></td>
        </tr>
        </tbody>
    </table>
        <input type="button" value="Clear" name="clear" />
        <input type="submit" value="Submit" name="submit" />
    </form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lamarlofton
  Date: 8/20/18
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logout Page</title>
</head>
<body>
    <%
    session.removeAttribute("userName");
    session.removeAttribute("passWord");
    session.invalidate();
    %>
    <h1>Logout was done Successfully.</h1>


</body>
</html>

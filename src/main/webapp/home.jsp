<%--
  Created by IntelliJ IDEA.
  User: lamarlofton
  Date: 8/20/18
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br/><br/><br/><br/><br/>
<center>
    <h2>
    <%
    String a=request.getParameter("username");
    out.println("Hello "+ ${username}!;
    %>
    </h2>
    <br/>
    <br/>
    <br/><br/><br/><br/><br/>
    <a href="logout.jsp">Logout</a>
    </center>

</body>
</html>

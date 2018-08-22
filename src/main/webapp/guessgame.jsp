<%--
  Created by IntelliJ IDEA.
  User: lamarlofton
  Date: 8/21/18
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Guess Guess</title>
</head>
<body>

    <h1>"Guess A Number Between 1-100"</h1>
    <form action="/guess" method="post">
        <input type="number" min="1" max="100">
        <button>Sumbit</button>

    </form>
</body>
</html>

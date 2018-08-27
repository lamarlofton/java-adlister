<%--
  Created by IntelliJ IDEA.
  User: lamarlofton
  Date: 8/24/18
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
<script>
    function validate(){
        var email = document.form.email.value;
        var username = document.form.username.value;
        var password = document.form.password.value;
        var conpassword = document.form.conpassword.value;

        else if(email == null || email == ""){
            alert("Email can't be blank");
            return false;
        }
        else if(username == null || username == ""){
            alert("Username can't be blank");
            return false;
        }
        else if(password.length < 5){
            alert("Password must be at least 5 characters long.");
            return false;
        }
        else if(password != conpassword){
            alert("Confirm Password should match with the Password");
            return false;
        }
    }
</script>
    <jsp:include page="WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Register"></jsp:param>
    </jsp:include>
</head>
<body>
<form name="form" action="/register" method="post" onsubmit="return validate()">
    <table align="center">
        <hr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"/></td>
        </tr>
        <hr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <hr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <hr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="conpassword"/></td>
        </tr>
        <tr>
            <td><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></td>
        </tr>
            <td></td>

            <td><input type="submit" value="Register">
                <input type="reset" value="Reset">
            </td>
        <%--</tr>--%>
    </table>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 06.04.2019
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>Register new User</h1>
<div>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <p> email <input type="text" name="email"/></p>
        <p>password <input type="text" name="password"/></p>
        <p>login <input type="text" name="login"/></p>
        <p><input type="submit" name="submit" value="register"/></p>
    </form>
</div>
<p style="color: red">${result}</p>
<jsp:include page="footer.jsp"/>
</body>
</html>

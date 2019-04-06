<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 30.03.2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Footer</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<p>created by ${name} , <%=LocalDate.now()%>
</p>

</body>
</html>

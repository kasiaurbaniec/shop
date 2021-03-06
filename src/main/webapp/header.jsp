<%@ page import="pl.sda.urbaniec.model.Role" %>
<%@ page import="pl.sda.urbaniec.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 30.03.2019
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>header</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <script src="https://use.fontawesome.com/releases/v5.8.1/js/all.js" data-auto-replace-svg="nest"></script>
</head>
<body>
<%
    final User user = (User) session.getAttribute("loggedUser");
    if (user != null && user.getRole().contains(Role.ADMIN)) {
%>
<a href="${pageContext.request.contextPath}/addProduct">ADD PRODUCT</a>
<%
    }
%>
<a href="${pageContext.request.contextPath}/database">HOME</a>
<a href="${pageContext.request.contextPath}/addToCart">CART</a>
<a href="${pageContext.request.contextPath}/register">REGISTER</a>
<%
    final User loggedUser = (User) session.getAttribute("loggedUser");
    if (loggedUser == null) {
%>
<a href="${pageContext.request.contextPath}/login">LOGIN</a>
<%
} else {
%>
<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
<%
        out.println(" HELLO " + loggedUser.getLogin().toUpperCase());
    }
%>
</body>
</html>

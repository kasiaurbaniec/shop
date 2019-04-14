<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 13.04.2019
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buy-data</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>ADD ADDRESS TO YOUR ORDER</h1>
<div>
    <form action="${pageContext.request.contextPath}/buy-data" method="post">
        <p>Name<input type="text" name="name">
        <p>Surname<input type="text" name="surname">
        <p>Street<input type="text" name="street">
        <p>StreetNumber<input type="text" name="streetNumber">
        <p>City<input type="text" name="city">
        <p>Code<input type="text" name="code">
        <p><input type="submit" name="submit" value="SUBMIT ADDRESS"/></p>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

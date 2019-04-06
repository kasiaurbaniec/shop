<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 06.04.2019
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD PRODUCT</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>AddProduct</h1>
<div>
    <form action="${pageContext.request.contextPath}/addProduct" method="post">
        <p> name <input type="text" name="name"/></p> <%--name= ma się tak samo nazywać jak parametr w servlecie--%>
        <p>description <input type="text" name="description"/></p>
        <p>price <input type="text" name="price"/></p>
        <p>category <input type="text" name="newCategory"/></p>
        <p>photo <input type="text" name="photoUrl"/></p>
        <p>submit <input type="submit" name="submit" value="submit"/></p>
    </form>
</div>
</body>
</html>

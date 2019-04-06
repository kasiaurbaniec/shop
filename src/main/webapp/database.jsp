<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 30.03.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smar_mydlo_i_powidlo</title>
    <jsp:include page="header.jsp"/>
    <div>
        <form action="${pageContext.request.contextPath}/database" method="get">
            <p>category <input type="text" name="category"/>
            </p> <%--name= ma się tak samo nazywać jak parametr w servlecie--%>
            <p>submit <input type="submit" name="submit" value="submit"/></p>
        </form>
    </div>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${products}" var="product">
    <div>
        <h4>${product.getName()}</h4>
        <p><img src=${product.getHref()}  height="100" alt="photo of item"/></p>
        <p>
        <li>id: ${product.getId()}</li>
        </p>
        <p>
        <li>data zamówienia: ${product.getDate()}</li>
        </p>
        <p>
        <li>opis: ${product.getDescription()}</li>
        </p>
        <p>
        <li>cena: ${product.getPrice()}</li>
        </p>
        <p>
        <li>kategoria: ${product.getCategories()}</li>
        </p>
    </div>

</c:forEach>
<jsp:include page="footer.jsp"/>
</body>
</html>

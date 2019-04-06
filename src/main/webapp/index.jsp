<%@ page import="pl.sda.urbaniec.DAO.ProductDB" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalDateTime" %>
<html>
<head>
    Fist Servlet
</head>
<body>
<div>
    <jsp:include page="header.jsp"/>
</div>
<h2>"Hello world!!</h2>
<div>
    <%! private final int counter = 0; %>
    <p><%=this.counter%>
    </p>
</div>
<div>
    <p><%!private final ProductDB lista = ProductDB.getInstance();%></p>
    <p><%=this.lista.getProductList()%>;%></p>

</div>

<div>
    <h3>current time: <%=LocalDateTime.now()%>
    </h3>
    <p>Next 10 days are: </p>
    <%!private final LocalDate today = LocalDate.now();%>
    <p><% for (int i = 0; i < 10; i++) {
        out.println(this.today.plusDays(i).toString() + "\n");
    }
    %></p>
</div>
<p>${name}</p>
<jsp:include page="footer.jsp"/>
</body>
</html>

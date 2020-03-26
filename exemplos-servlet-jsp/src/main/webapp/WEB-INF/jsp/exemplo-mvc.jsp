<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo Servlet + JSP MVC</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1 style="color: blue">Exemplo Servlet + JSP MVC</h1>
        <ul>
            <c:forEach items="${itensAttr}" var="item">
                <c:choose>
                    <c:when test="${item.isPar()}">
                        <li style="color: red;"><c:out value="${item.getTexto()}" /></li>
                    </c:when>
                    <c:otherwise>
                        <li style="color: green;"><c:out value="${item.getTexto()}" /></li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </body>
</html>

<%@page import="br.senac.tads.pi3.exemplos.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo JSP com SCRIPTLET</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1 style="color: blue">Exemplo JSP com Item e JSTL + EL</h1>
<%
        List<Item> itens = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Item item = new Item("Item " + i, i);
            itens.add(item);
        }
        request.setAttribute("itensAttr", itens);
%>
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

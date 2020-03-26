<%@page import="br.senac.tads.pi3.exemplos.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo JSP com SCRIPTLET</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1 style="color: blue">Exemplo JSP com Item e SCRIPTLET</h1>
        <h2 style="color: red">NÃO USAR</h2>
<%
        List<Item> itens = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Item item = new Item("Item " + i, i);
            itens.add(item);
        }
%>
        <ul>
            <% for (Item item : itens) {
                if (item.isPar()) { %>
                    <li style="color: red;"><%= item.getTexto() %></li>
                <% } else { %>
                    <li style="color: green;"><%= item.getTexto() %></li>
                <% }
            } %>
        </ul>
    </body>
</html>

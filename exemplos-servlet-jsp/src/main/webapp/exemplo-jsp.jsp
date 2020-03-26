<%@page import="java.time.LocalDateTime"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo JSP com SCRIPTLET</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1 style="color: blue">Exemplo JSP com SCRIPTLET</h1>
        <h2 style="color: red">NÃO USAR</h2>
        <p>Data e hora de acesso: <%= LocalDateTime.now() %></p>
        <ul>
            <% for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) { %>
                    <li style="color: red;">Item <%= i %></li>
                <% } else { %>
                    <li style="color: green;">Item <%= i %></li>
                <% }
            } %>
        </ul>
    </body>
</html>

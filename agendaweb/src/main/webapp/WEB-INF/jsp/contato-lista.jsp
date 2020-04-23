<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de contatos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <style>
            body {
                background-color: bisque;
            }
            .bg {
                background-color: white;
                width: 70%;
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <div class="bg">
        <h1>Lista de contatos</h1>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Apelido</th>
                        <th>Data nascimento</th>
                        <th>E-mail</th>
                        <th>Telefone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaContatos}" var="contato">
                        <tr>
                            <td><c:out value="${contato.id}" /></td>
                            <td><c:out value="${contato.nome}" /></td>
                            <td><c:out value="${contato.apelido}" /></td>
                            <td><c:out value="${contato.dataNascimento}" /></td>
                            <td>
                                <c:if test="${not empty contato.emails}">
                                    <c:out value="${contato.emails.get(0).getEndereco()}" />
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${not empty contato.telefones}">
                                    <c:out value="${contato.telefones.get(0).getNumero()}" />
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>


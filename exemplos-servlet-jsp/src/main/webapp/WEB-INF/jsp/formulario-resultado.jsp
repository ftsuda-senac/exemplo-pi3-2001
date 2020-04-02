<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <h1>Dados preenchidos pelo usuário</h1>
        <h3>ID: <c:out value="${idAttr}" /></h3>
        <h3>Nome : <c:out value="${nomeAttr}" /></h3>
        <h3>Descrição: <c:out value="${descricaoAttr}"/></h3>
        <h3>E-mail: <c:out value="${emailAttr}" /></h3>
        <h3>Senha: <c:out value="${senhaAttr}" /></h3>
        <h3>Repetir senha: <c:out value="${repetirSenhaAttr}" /></h3>
        <h3>Número da sorte: <c:out value="${numeroSorteAttr}" /></h3>
        <h3>Altura: <c:out value="${alturaAttr}" /></h3>
        <h3>Peso: <c:out value="${pesoAttr}" /></h3>
        <h3>Data nascimento: <c:out value="${dataNascAttr}" /></h3>
        <h3>Sexo:
            <c:choose>
                <c:when test="${sexoAttr eq '1'}">
                    Masculino
                </c:when>
                <c:otherwise>
                    Feminino
                </c:otherwise>
            </c:choose>
        </h3>
        <h3>Interesses:
            <ul>
                <c:forEach items="${interessesAttr}" var="interesse">
                    <li><c:out value="${interesse}" /></li>
                </c:forEach>
            </ul>
        </h3>
    </body>
</html>

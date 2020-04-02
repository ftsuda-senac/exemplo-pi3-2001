<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo parâmetros</title>
    </head>
    <body>
        <h1>Parâmetros informados via query string:</h1>
        <h3>Nome: <c:out value="${nomeAttr}" /></h3>
        <h3>Data nascimento: <c:out value="${dtNascAttr}" /></h3>
        <h3>Idade: <c:out value="${idade}" /></h3>
    </body>
</html>

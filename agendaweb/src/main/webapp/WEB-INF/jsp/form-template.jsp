<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agenda de contatos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .salvar {
                color: white;
                background-color: #27ae60;
            }
            .cancelar {
                color: white;
                background-color: #95a5a6;
            }
        </style>
    </head>
    <body>
        <h1>Agenda de contatos</h1>
        <c:choose>
            <c:when test="${acao == 'incluir'}">
                <h2>Incluir novo</h2>
            </c:when>
            <c:when test="${acao == 'alterar'}">
                <h2>Alterar</h2>
            </c:when>
            <c:otherwise>
                <h2>ERRO</h2>
            </c:otherwise>
        </c:choose>
        
        <form method="post" action="${pageContext.request.contextPath}/contatos/salvar">
            <div>
                <label>Nome completo</label>
                <div>
                    <input type="text" name="nome">
                </div>
            </div>
            <div>
                <label>Apelido</label>
                <div>
                    <input type="text" name="apelido">
                </div>
            </div>
            <div>
                <label>Data de nascimento</label>
                <div>
                    <input type="date" name="dtnascimento">
                </div>
            </div>
            <div>
                <label>Telefone</label>
                <div>
                    <input type="text" name="telefone">
                </div>
            </div>
            <div>
                <label>E-mail</label>
                <div>
                    <input type="text" name="email"
                </div>
            </div>
           <div>
               <label>Senha</label>
                <div>
                    <input type="password" name="senha">
                </div>
            </div>
           <div>
               <label>Numero cartao de credito</label>
                <div>
                    <input type="text" name="cc">
                </div>
            </div>
            <div>
                <button type="button" class="cancelar">Cancelar</button>
                <button type="submit" class="salvar">Salvar</button>
            </div>
        </form>
    </body>
</html>


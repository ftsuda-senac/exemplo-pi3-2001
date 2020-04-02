<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <style>
            .erro-input {
                color: #e74c3c;
            }
            .com-erro {
                display: block;
            }
            input[type='text'],
            input[type='email'],
            input[type='number'],
            input[type='password'],
            input[type='date'],
            textarea {
                width: 100%;
            }
        </style>
        <script src="${pageContext.request.contextPath}/teste-js.js"></script>
    </head>
    <body>
        <main>
            <div>
                <section style="width: 70%; margin: 0 auto">
                    <h1>Formulário (COM VALIDACAO SERVER-SIDE)</h1>
                    <form method="post" action="${pageContext.request.contextPath}/formulario/salvar" novalidate>
 
                        <input type="hidden" name="id" value="${param.id}">

                        <div>
                            <label for="txtNome">
                                Nome
                            </label>
                            <div>
                                <input type="text" name="nome" id="txtNome" 
                                       placeholder="Nome" 
                                       required maxlength="100" value="${param.nome}" />
                                <c:if test="${erroNome != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroNome}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>

                        <div>
                            <label for="txtDescricao">
                                Descrição
                            </label>
                            <div>
                                <textarea name="descricao" id="txtDescricao" placeholder="Descrição">${param.descricao}</textarea>
                            </div>
                        </div>

                        <div>
                            <label for="txtEmail">
                                E-mail
                            </label>
                            <div>
                                <input type="email" name="email" id="txtEmail" 
                                       placeholder="E-mail"
                                       required value="${param.email}" />
                                <c:if test="${erroEmail != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroEmail}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label for="txtSenha">
                                Senha
                            </label>
                            <div>
                                <input type="password" name="senha" id="txtSenha" 
                                       placeholder="Senha">
                                <c:if test="${erroSenha != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroSenha}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div>
                            <label for="txtRepetirSenha">
                                Repetir senha
                            </label>
                            <div>
                                <input type="password" name="repetirSenha" id="txtRepetirSenha" 
                                      placeholder="Repetir senha">
                            </div>
                        </div>

                        <div>
                            <label for="txtNumero">
                                Número da sorte
                            </label>
                            <div>
                                <input type="number" name="numeroSorte" id="txtNumero" 
                                       placeholder="Número de 1 a 99" 
                                       min="1" max="99" value="${param.numeroSorte}" >
                                <c:if test="${erroNumeroSorte != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroNumeroSorte}" />
                                    </div>
                                </c:if>

                            </div>
                        </div>

                        <div>
                            <label for="txtAltura">
                                Altura
                            </label>
                            <div>
                                <input type="number" name="altura" id="txtAltura" 
                                       placeholder="Altura em metros com no máximo 2 casa decimais" 
                                       min="0" max="9.99" step="0.01" value="${param.altura}">
                                <c:if test="${erroAltura != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroAltura}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>

                        <div>
                            <label for="txtPeso">
                                Peso
                            </label>
                            <div>
                                <input type="number" name="peso" id="txtPeso" 
                                       placeholder="Peso em Kg com no máximo 1 casa decimal" 
                                       min="0" max="999.9" step="0.1" value="${param.peso}">
                            </div>
                        </div>

                        <div>
                            <label for="txtDtNascimento">
                                Data de nascimento
                            </label>
                            <div>
                                <input type="date" name="dtNascimento" id="txtDtNascimento" 
                                       value="${param.dtNascimento}"/>
                                <c:if test="${erroDtNasc != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroDtNasc}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>

                        <fieldset>
                            <legend>Sexo</legend>
                            <div>
                                <div>
                                    <input type="radio" name="sexo" 
                                           id="optSexoF" value="0" ${(param.sexo == null || param.sexo != 1) ? 'checked' : ''} />
                                    <label for="optSexoF">
                                        Feminino
                                    </label>
                                </div>
                                <div>
                                    <input type="radio" name="sexo"
                                           id="optSexoM" value="1" ${param.sexo == 1 ? 'checked' : ''}/>
                                    <label for="optSexoM">
                                        Masculino
                                    </label>
                                </div>
                            </div>
                        </fieldset>

                        <fieldset>
                            <legend>Interesses</legend>
                            <div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesTecnologia" value="Tecnologia" ${param.interesses.contains('Tecnologia') ? 'checked' : ''} />
                                    <label for="interessesTecnologia">
                                        Tecnologia
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesGastronomia" value="Gastronomia" ${param.interesses.contains('Gastronomia') ? 'checked' : ''} />
                                    <label for="interessesGastronomia">
                                        Gastronomia
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesViagens" value="Viagens" ${param.interesses.contains('Viagens') ? 'checked' : ''} />
                                    <label for="interessesViagens">
                                        Viagens
                                    </label>
                                </div>
                                <div>
                                    <input type="checkbox" name="interesses" 
                                           id="interessesInvestimentos" value="Investimentos" ${param.interesses.contains('Investimentos') ? 'checked' : ''} />
                                    <label for="interessesInvestimentos">
                                        Investimentos
                                    </label>
                                </div>
                                <c:if test="${erroInteresses != null}">
                                    <div class="erro-input">
                                        <c:out value="${erroInteresses}" />
                                    </div>
                                </c:if>
                            </div>
                        </fieldset>
                        <div>
                            <button type="submit">Enviar</button>
                            <button type="reset">Resetar dados</button>
                            <a href="#" role="button">Cancelar</a>
                        </div>
                    </form>
                </section>
            </div>
        </main>

    </body>
</html>

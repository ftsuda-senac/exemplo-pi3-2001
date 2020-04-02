/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fedts
 */
@WebServlet(name = "FormularioSalvarServlet", urlPatterns = {"/formulario/salvar"})
public class FormularioSalvarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        // Recuperar os dados preenchidos pelo usuário
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String repetirSenha = request.getParameter("repetirSenha");
        String numeroSorteStr = request.getParameter("numeroSorte");
        String alturaStr = request.getParameter("altura");
        String pesoStr = request.getParameter("peso");
        String dataNascStr = request.getParameter("dtNascimento");
        String sexoOptStr = request.getParameter("sexo");
        String[] interesses = request.getParameterValues("interesses");
        
        // Validacao
        boolean temErros = false;
        if (nome == null || nome.trim().length() < 1) {
            temErros = true;
            request.setAttribute("erroNome", "Preenchimento do nome é obrigatório");
        }
        if (email == null || email.trim().length() < 1) {
            temErros = true;
            request.setAttribute("erroEmail", "Preenchimento do e-mail é obrigatório");
        }
        if (senha != null && repetirSenha != null) {
            if (!senha.equals(repetirSenha)) {
                temErros = true;
                request.setAttribute("erroSenha", "Senhas são diferentes");
            }
        } else if (senha != null) {
            temErros = true;
            request.setAttribute("erroSenha", "Senhas são diferentes");
        } else if (repetirSenha != null) {
            temErros = true;
            request.setAttribute("erroSenha", "Senhas são diferentes");
        }
        if (numeroSorteStr != null && numeroSorteStr.trim().length() > 0) {
            int numeroSorte = 0;
            try {
                numeroSorte = Integer.parseInt(numeroSorteStr);
                if (numeroSorte < 1 || numeroSorte > 99) {
                temErros = true;
                request.setAttribute("erroNumeroSorte", "Número da sorte deve ser entre 1 e 99");
                }
            } catch (NumberFormatException e) {
                temErros = true;
                request.setAttribute("erroNumeroSorte", "Valor digitado não é um número");
            }
        }
        if (alturaStr != null && alturaStr.trim().length() > 0) {
            BigDecimal altura = null;
            try {
                altura = new BigDecimal(alturaStr);
                // Verifica se altura informada é menor que 0 OU altura é maior que 9,99
                if (altura.compareTo(new BigDecimal("0")) < 0 || altura.compareTo(new BigDecimal("10")) >= 0) {
                    temErros = true;
                    request.setAttribute("erroAltura", "Altura informada deve estar entre 0 e 9,99");
                }
            } catch (Exception e) {
                temErros = true;
                request.setAttribute("erroAltura", "Valor digitado não é um número válido");
            }
        }
        
        int idade = -1;
        if (dataNascStr != null && dataNascStr.trim().length() > 1) {
            LocalDate dtNasc = LocalDate.parse(dataNascStr);
            if (dtNasc.isAfter(LocalDate.now())) {
                temErros = true;
                request.setAttribute("erroDtNasc", "Data de nascimento deve ser no passado");
            }
            Period periodo = Period.between(dtNasc, LocalDate.now());
            idade = periodo.getYears();
        }
        
        if (interesses == null || interesses.length < 1) {
            temErros = true;
            request.setAttribute("erroInteresses", "Selecionar pelo menos 1 interesse");
        }
        
        if (temErros) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formulario-validacao.jsp");
            dispatcher.forward(request, response);
            return;
        }
        
        // Processamento

        
        // Montar resposta para usuario.
        request.setAttribute("idAttr", idStr);
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("descricaoAttr", descricao);
        request.setAttribute("emailAttr", email);
        request.setAttribute("senhaAttr", senha);
        request.setAttribute("repetirSenhaAttr", repetirSenha);
        request.setAttribute("numeroSorteAttr", numeroSorteStr);
        request.setAttribute("alturaAttr", alturaStr);
        request.setAttribute("pesoAttr", pesoStr);
        request.setAttribute("dataNascAttr", dataNascStr);
        request.setAttribute("idade", idade);
        request.setAttribute("sexoAttr", sexoOptStr);
        request.setAttribute("interessesAttr", interesses);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formulario-resultado.jsp");
        dispatcher.forward(request, response);

    }

}

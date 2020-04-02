/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ParametrosServlet", urlPatterns = {"/parametros"})
public class ParametrosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nome;
        String dtNascStr;
        
        nome = request.getParameter("nome");
        dtNascStr = request.getParameter("dtnasc");
        
        LocalDate dtNasc = LocalDate.parse(dtNascStr);
        Period periodo = Period.between(dtNasc, LocalDate.now());
        int idade = periodo.getYears();
        
        request.setAttribute("nomeAttr", nome);
        request.setAttribute("dtNascAttr", dtNascStr);
        request.setAttribute("idade", idade);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/parametros.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}

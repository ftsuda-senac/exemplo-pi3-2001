/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fedts
 */
@WebServlet(name = "ExemploServlet", urlPatterns = "/exemplo-servlet")
public class ExemploServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Resposta gerado pelo Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"color:red\">Resposta gerada pelo Servlet</h1>");
            out.println("<p>Data e hora de acesso: " + LocalDateTime.now() + "</p>");
            out.println("<ul>");
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) { // Número pares
                    out.println("<li style=\"color: red\">Item " + i + "</li>");
                } else { // Números impares
                    out.println("<li style=\"color: green\">Item " + i + "</li>");
                }
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}

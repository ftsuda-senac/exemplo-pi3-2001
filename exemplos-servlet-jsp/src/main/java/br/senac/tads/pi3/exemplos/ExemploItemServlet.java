/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fedts
 */
@WebServlet(name = "ExemploItemServlet", urlPatterns = "/exemplo-item-servlet")
public class ExemploItemServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        List<Item> itens = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Item item = new Item("Item " + i, i);
            itens.add(item);
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Resposta gerado pelo Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 style=\"color:red\">Exemplo Servlet com Item</h1>");
            out.println("<ul>");
            for (Item item : itens) {
                if (item.isPar()) {
                     out.println("<li style=\"color: red\">" + item.getTexto() + "</li>");
                } else {
                    out.println("<li style=\"color: green\">" + item.getTexto() + "</li>");
                }
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}

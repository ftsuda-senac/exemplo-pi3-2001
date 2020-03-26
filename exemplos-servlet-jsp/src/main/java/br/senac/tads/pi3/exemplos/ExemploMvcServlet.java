/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exemplos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ExemploMvcServlet", urlPatterns = {"/exemplo-mvc"})
public class ExemploMvcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Item> itens = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            Item item = new Item("Item " + i, i);
            itens.add(item);
        }
        request.setAttribute("itensAttr", itens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/exemplo-mvc.jsp");
        dispatcher.forward(request, response);
    }

}

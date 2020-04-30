/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.servlet;

import br.senac.tads.pi3.agendaweb.model.entidades.Contato;
import br.senac.tads.pi3.agendaweb.model.servicos.AppException;
import br.senac.tads.pi3.agendaweb.model.servicos.ContatoService;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ContatoListaServlet", urlPatterns = {"/contatos"})
public class ContatoListaServlet extends HttpServlet {
    
    private ContatoService service = new ContatoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Contato> contatos = service.listar();
            request.setAttribute("listaContatos", contatos);
        } catch(AppException e) {
            // Se ocorrer erro, obtem a mensagem da exceção
            String msg = e.getMessage();
            request.setAttribute("msgErro", msg);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/lista-template.jsp").forward(request, response);
    }

}

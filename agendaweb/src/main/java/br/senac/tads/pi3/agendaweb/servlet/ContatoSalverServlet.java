/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.servlet;

import br.senac.tads.pi3.agendaweb.model.entidades.Contato;
import br.senac.tads.pi3.agendaweb.model.entidades.Email;
import br.senac.tads.pi3.agendaweb.model.entidades.Telefone;
import br.senac.tads.pi3.agendaweb.model.servicos.AppException;
import br.senac.tads.pi3.agendaweb.model.servicos.ContatoService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ContatoSalverServlet", urlPatterns = {"/contatos/salvar"})
public class ContatoSalverServlet extends HttpServlet {
    
    private ContatoService service  = new ContatoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String nome = request.getParameter("nome");
        String apelido = request.getParameter("apelido");
        String dtNascimentoStr = request.getParameter("dtnascimento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        
        Contato c = new Contato();
        c.setNome(nome);
        c.setApelido(apelido);
        LocalDate dtNascimento = LocalDate.parse(dtNascimentoStr);
        c.setDataNascimento(dtNascimento);
        
        // Converte o Telefone em uma lista de 1 elemento
        Telefone t = new Telefone();
        t.setNumero(telefone);
        t.setTipo("PESSOAL");
        List<Telefone> telefones = Arrays.asList(t);

        // Converte o Email em uma lista de 1 elemento
        Email e = new Email();
        e.setEndereco(email);
        e.setTipo("PESSOAL");
        List<Email> emails = Arrays.asList(e);
        
        c.setTelefones(telefones);
        c.setEmails(emails);
        
        HttpSession sessao = request.getSession();
        try {
            service.incluir(c);
            sessao.setAttribute("msgSucesso", "Contato salvo com sucesso");
        } catch (AppException ex) {
            sessao.setAttribute("msgErro", "Erro ao salvar contato - " + ex.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/contatos");

    }

}

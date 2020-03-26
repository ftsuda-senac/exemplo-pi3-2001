/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.model.servicos;

import br.senac.tads.pi3.agenda.model.dao.ContatoDao;
import br.senac.tads.pi3.agenda.model.entidades.Contato;
import br.senac.tads.pi3.agenda.model.entidades.Email;
import br.senac.tads.pi3.agenda.model.entidades.Telefone;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe contendo ações para gerenciar os contatos
 *
 * @author fernando.tsuda
 */
public class ContatoService {
    
    private ContatoDao dao = new ContatoDao();

    public List<Contato> listar() {
        return dao.listar();
    }

    public List<Contato> pesquisar(String termo) {
        return null;
    }

    public void incluir(Contato c) {
        if (c != null && c.getNome() != null && c.getApelido() != null) {
            dao.incluir(c);
        }
    }

    public void excluir(Integer id) {

    }

    public Contato consultar(Integer id) {
        return null;
    }

    public void alterar(Contato c) {

    }
}

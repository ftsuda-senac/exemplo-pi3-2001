/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.model.servicos;

import br.senac.tads.pi3.agendaweb.model.dao.ContatoDao;
import br.senac.tads.pi3.agendaweb.model.entidades.Contato;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author fedts
 */
public class ContatoService {
    
    private ContatoDao dao = new ContatoDao();
    
    public List<Contato> listar() throws AppException {
        try {
            return dao.listar();
        } catch (SQLException e) {
            throw new AppException("ERRO NA CONSULTA DOS DADOS", e);
        }
    }
    
    private boolean isValid(Contato c) {
        if (c != null && c.getNome() != null && c.getApelido() != null) {
            return true;
        }
        return false;
    }
    
    public void incluir(Contato c) throws AppException {
        try {
            if (isValid(c)) {
                dao.incluir(c);
            } else {
                 throw new AppException("DADOS INVALIDOS", null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new AppException("ERRO NA INCLUSAO DOS DADOS", e);
        }
    }
}

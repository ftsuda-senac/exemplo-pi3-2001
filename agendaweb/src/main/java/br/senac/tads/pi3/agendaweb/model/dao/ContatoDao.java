/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.model.dao;

import br.senac.tads.pi3.agendaweb.model.entidades.Contato;
import br.senac.tads.pi3.agendaweb.model.entidades.Email;
import br.senac.tads.pi3.agendaweb.model.entidades.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fedts
 */
public class ContatoDao {
    
    public List<Contato> listar() throws SQLException {
        String sql = "SELECT id, nome, apelido, data_nascimento FROM CONTATO";
        List<Contato> contatos = new ArrayList<>();
        try (Connection conn = ConnectionUtilsMySQL.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
                
                String sqlTelefone = "SELECT id, numero, tipo FROM telefone WHERE id_contato = ?";
                try (PreparedStatement stmtTelefone = conn.prepareStatement(sqlTelefone)) {
                    stmtTelefone.setInt(1, c.getId());
                    try (ResultSet rsTelefone = stmtTelefone.executeQuery()) {
                        List<Telefone> telefones = new ArrayList<>();
                        while (rsTelefone.next()) {
                            Telefone t = new Telefone();
                            t.setId(rsTelefone.getInt("id"));
                            t.setNumero(rsTelefone.getString("numero"));
                            t.setTipo(rsTelefone.getString("tipo"));
                            telefones.add(t);
                        }
                        c.setTelefones(telefones);
                    }
                }
                
                String sqlEmail = "SELECT id, endereco, tipo FROM email WHERE id_contato = ?";
                try (PreparedStatement stmtEmail = conn.prepareStatement(sqlEmail)) {
                    stmtEmail.setInt(1, c.getId());
                    try (ResultSet rsEmail = stmtEmail.executeQuery()) {
                        List<Email> emails = new ArrayList<>();
                        while (rsEmail.next()) {
                            Email e = new Email();
                            e.setId(rsEmail.getInt("id"));
                            e.setEndereco(rsEmail.getString("endereco"));
                            e.setTipo(rsEmail.getString("tipo"));
                            emails.add(e);
                        }
                        c.setEmails(emails);
                    }
                }
                contatos.add(c);
            }
        }
        return contatos;
    }
    
}

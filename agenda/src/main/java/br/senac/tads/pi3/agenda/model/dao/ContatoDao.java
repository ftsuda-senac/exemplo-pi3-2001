/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agenda.model.dao;

import br.senac.tads.pi3.agenda.model.entidades.Contato;
import br.senac.tads.pi3.agenda.model.entidades.Email;
import br.senac.tads.pi3.agenda.model.entidades.Telefone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fernando.tsuda
 */
public class ContatoDao {

    public List<Contato> listar() {
        String sql = "SELECT id, nome, apelido, data_nascimento FROM contato";
        // CÓDIGO ABAIXO SOMENTE PARA JAVA 7 OU SUPERIOR
        List<Contato> resultados = new ArrayList<>();
        try (Connection conn = ConnectionUtilsMySQL.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Contato c = new Contato();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setApelido(rs.getString("apelido"));
                c.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());

                // Pesquisar email
                List<Email> listaEmail = new ArrayList<>();
                String sqlEmail = "SELECT id, endereco, tipo FROM email WHERE id_contato = ?";
                try (PreparedStatement stmtEmail = conn.prepareStatement(sqlEmail)) {
                    stmtEmail.setInt(1, c.getId());
                    try (ResultSet rsEmail = stmtEmail.executeQuery()) {
                        while (rsEmail.next()) {
                            Email e = new Email();
                            e.setId(rsEmail.getInt("id"));
                            e.setEndereco(rsEmail.getString("endereco"));
                            e.setTipo(rsEmail.getString("tipo"));
                            listaEmail.add(e);
                        }
                    }
                }
                c.setEmails(listaEmail);

                // Pesquisar telefones
                List<Telefone> listaTelefones = new ArrayList<>();
                String sqlTelefone = "SELECT id, numero, tipo FROM telefone WHERE id_contato = ?";
                try (PreparedStatement stmtTelefone = conn.prepareStatement(sqlTelefone)) {
                    stmtTelefone.setInt(1, c.getId());
                    try (ResultSet rsTelefone = stmtTelefone.executeQuery()) {
                        while (rsTelefone.next()) {
                            Telefone t = new Telefone();
                            t.setId(rsTelefone.getInt("id"));
                            t.setNumero(rsTelefone.getString("numero"));
                            t.setTipo(rsTelefone.getString("tipo"));
                            listaTelefones.add(t);
                        }
                    }
                }
                c.setTelefones(listaTelefones);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultados;
    }

    public List<Contato> pesquisar(String termo) {
        return null;
    }

    public void incluir(Contato c) {
       String sql = "INSERT INTO contato (nome, apelido, data_nascimento) VALUES (?,?,?)";
        try (Connection conn = ConnectionUtilsMySQL.obterConexaoBD()) {
            // DESLIGAR O AUTO COMMIT
            conn.setAutoCommit(false);

            // ADICIONAR O Statement.RETURN_GENERATED_KEYS NA CHAMADA DO MÉTODO
            try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, c.getNome());
                stmt.setString(2, c.getApelido());
                stmt.setDate(3, java.sql.Date.valueOf(c.getDataNascimento()));
                int resultados = stmt.executeUpdate();
                try (ResultSet chaves = stmt.getGeneratedKeys()) {
                    if (chaves.next()) {
                        int idGerado = chaves.getInt(1);
                        // USA O ID GERADO PARA DEMAIS OPERACOES
                        
                        // SALVAR EMAILS
                        
                        // SALVAR TELEFONES

                    }
                }
                // EFETIVA TODAS AS OPERAÇÕES REALIZADAS
                conn.commit();
            } catch (Exception ex) {
                // OCORREU ALGUM ERRO NA LÓGICA ACIMA - DESFAZ AS OPERAÇÕES ANTERIORES
                ex.printStackTrace();
                conn.rollback();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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

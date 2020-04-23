/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author fedts
 */
public class ConnectionUtilsMySQL {
        
    /**
     * Função responsável pela obtenção de uma conexão com BD.
     *
     * @return objeto {@link Connection}
     * @throws SQLException
     */
    public static final Connection obterConexaoBD() throws SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        // Neste caso, conectando com MySQL 8.x
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException(ex);
        }

        // 1B) Abrir a conexão
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/agendabd?"
                + "useUnicode=yes&"
                + "characterEncoding=UTF-8&"
                + "useTimezone=true&"
                + "serverTimezone=UTC",
                "tads", // Usuário de conexão
                "tads1234"); // Senha
        return conn;
    }
}

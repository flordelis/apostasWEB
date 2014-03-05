/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.bolao.testeconexao;

import java.sql.Connection;
import br.ifba.pweb.bolao.persistence.derby.ConnexaoFactory;
import java.sql.SQLException;
/**
 *
 * @author lisy
 */
public class TesteConexao {
    
    public static void main(String[] args) throws SQLException {
        Connection connection  = new ConnexaoFactory().getConnection();
        System.out.println("Conexao Aberta");  
        connection.close();
        System.out.println("Conexao Fechada");
    }
    
}

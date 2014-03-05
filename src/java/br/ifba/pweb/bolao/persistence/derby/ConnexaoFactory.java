/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lisy
 */
public class ConnexaoFactory {
     private static final String URL ="jdbc:derby:bolaoteste;create=true;user=bolaoteste;password=1234";
    // private static final String DRIVER="org.apache.derby.jdbc.EmbeddedDriver";
    public Connection getConnection(){
      System.out.println("Conectando ao Banco de Dados...");
        try{
         return DriverManager.getConnection(URL);
        } catch(SQLException e){
        throw new RuntimeException(e);  
         }
   }


}

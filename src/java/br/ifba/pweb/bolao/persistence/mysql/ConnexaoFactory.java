/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.mysql;

//import br.ifba.pweb.bolao.persistence.derby.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lisy
 */
public class ConnexaoFactory {
     private static final String URL ="jdbc:mysql://192.168.3.15:3306/bolaoonline";
     private static final String USER = "helis";
     private static final String PASSWORD="1234";
     //private static final String DRIVER="com.mysql.jdbc.Driver";
    public Connection getConnection() {
      System.out.println("Conectando ao Banco de Dados...");
        try{
         //Class.forName(DRIVER);
         return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(SQLException e){
        throw new RuntimeException(e);  
         }
   }


}

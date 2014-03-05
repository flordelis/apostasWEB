/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Nacao;
import br.ifba.pweb.bolao.persistence.ConnexaoFactory;
import br.ifba.pweb.bolao.persistence.IDAONacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAONacao implements IDAONacao{
  Connection connection;
    
    public DbDAONacao() {
        connection = new ConnexaoFactory().getConnection();
    }
    @Override
    public Set<Nacao> recuperarTodos() throws Exception {
        Set<Nacao> n=null;
        String SQL="Select * from \"nacao\"";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               n.add(new Nacao());
               
               for(Nacao na:n){
               na.setId(rs.getInt("id"));
               na.setNome(rs.getString("nome"));
               }
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return n;
    
    }
}

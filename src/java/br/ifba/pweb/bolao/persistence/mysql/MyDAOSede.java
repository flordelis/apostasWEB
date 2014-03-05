/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.mysql;

import br.ifba.pweb.bolao.persistence.derby.*;
import br.ifba.pweb.bolao.base.Sede;
import br.ifba.pweb.bolao.persistence.IDAOSede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class MyDAOSede implements IDAOSede{

    Connection connection;
    public MyDAOSede() {
        connection= new ConnexaoFactory().getConnection();
    }

    @Override
    public Set<Sede> recuperarTodos() throws Exception {
        Set<Sede> s=null;
        String SQL="Select * from `sede`";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                s.add(new Sede(rs.getInt("`id`"), rs.getString("`nome`")));
               
             
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return s;
    
    }

    @Override
    public Sede recuperarpeloId(int id) throws Exception {
        Sede s=null;
        String SQL="Select * from `sede` where `id`=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               s= new Sede(id, rs.getString("`nome`"));
              }
            
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return s;
    }
    }
    


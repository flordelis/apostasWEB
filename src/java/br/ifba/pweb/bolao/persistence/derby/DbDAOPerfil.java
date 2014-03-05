/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAOPerfil implements IDAOPerfil{

    Connection connection;
            
    public DbDAOPerfil() {
        connection = new ConnexaoFactory().getConnection();
        
    }

    
    @Override
    public void salvar(Perfil p) throws Exception {
        String sql="INSERT INTO \"perfil\" (\"nome\") VALUES " +
                   "(?)";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, p.getNome());
         stmt.execute();
         stmt.close();
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
          connection.close();
        }
    }

    @Override
    public void altualizarCredito(int valor, Perfil p) throws Exception {
       String sql="UPDATE \"perfil\" SET \"credito\"=?  where id=?";
                
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setInt(1, valor);
         stmt.setInt(1, p.getId());
         
         stmt.execute();
         stmt.close();
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
          connection.close();
        }
    }

    @Override
    public Perfil recuperarPeloId(int id) throws Exception {
        Perfil p=null;
        String SQL="Select * from \"perfil\" WHERE \"id\"=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               p = new Perfil(rs.getString("nome"));
               p.setData_criacao(rs.getDate("data_criada"));
               p.setId(rs.getInt("id"));
               p.setCredito(rs.getInt("credito"));
            
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return p;
    } 
    

    @Override
    public Perfil recuperarPeloIdUsuario(int iduser) throws Exception {
         Perfil p=null;
        String SQL="Select \"p.nome\", \"p.data_criada\", \"p.id\", \"p.credito\" from \"perfil\" p, \"usuario\" u WHERE p.\"id\"==u.\"id_perfil\" and u.\"id_perfil\"= ?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, iduser);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               p = new Perfil(rs.getString("\"p.nome\""));
               p.setData_criacao(rs.getDate("\"p.data_criada\""));
               p.setId(rs.getInt("\"p.id\""));
               p.setCredito(rs.getInt("\"p.credito\""));
            
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return p;
    } 

    @Override
    public Set<Perfil> recuperarTodos() throws Exception {
        Set<Perfil> p= new HashSet();
        String SQL="Select * from \"perfil\" p";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               p.add(new Perfil(rs.getString("\"nome\"")));
               
               for(Perfil pf:p){
               pf.setData_criacao(rs.getDate("\"data_criada\""));
               pf.setId(rs.getInt("\"id\""));
               pf.setCredito(rs.getInt("\"credito\""));
               }
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return p;
    } 

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import br.ifba.pweb.bolao.persistence.IDAOUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;


/**
 *
 * @author lisy
 */
public class DbDAOUsuario implements IDAOUsuario{

    Connection connection;
    
    public DbDAOUsuario() {
        connection = new ConnexaoFactory().getConnection();
    }
   
    @Override
    public void salvar(Usuario u) throws Exception {
        String sql="INSERT INTO \"usuario\" (\"login\", \"senha\", \"papel\") VALUES " +
                   "(?,?,?)";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, u.getLogin());
         stmt.setString(1, u.getSenha());
         stmt.setString(1, u.getPermissao());
         
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
    public void excluir(Usuario u) throws Exception  {
        String sql="DELETE FROM \"usuario\" WHERE \"login\"=? AND \"senha\"=?";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, u.getLogin());
         stmt.setString(2, u.getSenha());
         stmt.execute();
         stmt.close();
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
            try {
                connection.close();
            } catch (SQLException ex) {
               throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) throws Exception{
       Usuario u = null; 
       String sql="SELETE * FROM \"usuario\" WHERE \"login\"=?;";
        try{
            IDAOPerfil pdao = new DbDAOPerfil();
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, login);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                u=new Usuario(rs.getInt("\"id\""), rs.getString("\"login\""), rs.getString("\"senha\""),rs.getString("\"papel\""));
            
             }
              
         stmt.close();
         
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
          connection.close();
        }
        
     return u;   
    }

    @Override
    public void atualizar(Usuario u) throws Exception {
        String sql="UPDATE \"usuario\" SET \"logion\"=? \"senha\"=? WHERE \"id\"=?;";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, u.getLogin());
            stmt.setString(1, u.getSenha());
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
    public Usuario carregar(Integer codigo) throws Exception {
           
       Usuario u = null; 
       String sql="SELETE * FROM \"usuario\" WHERE \"id\"=?;";
        
       try{
            IDAOPerfil pdao = new DbDAOPerfil();
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, codigo);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                u=new Usuario(rs.getInt("\"id\""), rs.getString("\"login\""), rs.getString("\"senha\""), rs.getString("\"papel\""));
                        
             }
                  
         stmt.close();
         
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
          connection.close();
        }
        
     return u;   
    }

    @Override
    public Set<Usuario> listar() throws Exception {
       Set<Usuario> u = null; 
       String sql="SELETE * FROM \"usuario\"";
        
       try{
            IDAOPerfil pdao = new DbDAOPerfil();
            PreparedStatement stmt = connection.prepareStatement(sql); 
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                u.add(new Usuario(rs.getInt("\"id\""), rs.getString("\"login\""), rs.getString("\"senha\""), rs.getString("\"papel\"")));
                        
             }
                  
         stmt.close();
         
        }
        catch(SQLException e){
          throw new RuntimeException(e);
        }
        finally{
          connection.close();
        }
        
     return u;   
    }
}

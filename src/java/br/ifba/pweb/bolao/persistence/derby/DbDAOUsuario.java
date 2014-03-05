/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Perfil;
import br.ifba.pweb.bolao.beans.Usuario;
import br.ifba.pweb.bolao.persistence.ConnexaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
         stmt.setString(1, u.getPapel());
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
    public void salvar(Usuario u, Perfil p) throws Exception {
        String sql="INSERT INTO \"usuario\" (\"login\", \"senha\", \"id_perfil\") VALUES " +
                   "(?,?,?)";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, u.getLogin());
         stmt.setString(1, u.getSenha());
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
    public void remover(Usuario u) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario recuperarPeloLogin(String login) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

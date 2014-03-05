/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.mysql;

import br.ifba.pweb.bolao.persistence.derby.*;
import br.ifba.pweb.bolao.beans.Usuario;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import br.ifba.pweb.bolao.persistence.IDAOUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lisy
 */
public class MyDAOUsuario implements IDAOUsuario{

    Connection connection;
    
    public MyDAOUsuario() {
        connection = new ConnexaoFactory().getConnection();
    }
   
    @Override
    public void salvar(Usuario u) throws Exception {
        String sql="INSERT INTO `usuario` (`login`, `senha`, `papel`) VALUES " +
                   "(?,?,?)";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, u.getLogin());
         stmt.setString(1, u.getSenha());
         if(u.getPerfil()!=null){
         stmt.setInt(1, u.getPerfil().getId());
         }
         if(u.getPapel().equals("A")){
            stmt.setString(1, u.getPapel());
         }
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
    public void removerPeloLoginSenha(Usuario u) throws Exception {
        String sql="DELETE FROM `usuario` WHERE `login`=? AND `senha`=?";
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
          connection.close();
        }
    }

    @Override
    public Usuario recuperarPeloLoginSenha(String login, String senha) throws Exception {
       Usuario u = null; 
       String sql="SELETE * FROM `usuario` WHERE `login`=? AND `senha`=?";
        try{
            IDAOPerfil pdao = new MyDAOPerfil();
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
                u=new Usuario(rs.getInt("`id`"));
                u.setLogin(rs.getString("`login`"));
                u.setSenha(rs.getString("`senha`"));
                u.setPapel(rs.getString("`papel`"));
                if(rs.getInt("`perfil_id`")!=0)
                   u.setPerfil(pdao.recuperarPeloId(rs.getInt("`perfil_id`"))); 
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

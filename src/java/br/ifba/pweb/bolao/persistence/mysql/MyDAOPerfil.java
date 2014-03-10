/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.mysql;

//import br.ifba.pweb.bolao.persistence.derby.*;
import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import br.ifba.pweb.bolao.persistence.IDAOUsuario;
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
public class MyDAOPerfil implements IDAOPerfil{

    Connection connection;
    private MyDAOUsuario IDAOUsuario;
            
    public MyDAOPerfil() {
        connection = new ConnexaoFactory().getConnection();
        
    }

    
    @Override
    public void salvar(Perfil p) throws Exception {
        String sql="INSERT INTO `perfil` (`nome`) VALUES " +
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
    public void atualizar(Perfil p) throws Exception {
       String sql="UPDATE `perfil` SET `credito`=?  where idperfil=?";
                
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setInt(1, p.getCredito());
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
    public Perfil carregar(int idperfil) throws Exception {
        Perfil p= new Perfil();
        String SQL="SELECT * FROM `perfil` WHERE `idperfil`=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idperfil);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               p.setNome(rs.getString("nome"));
                IDAOUsuario  u= new MyDAOUsuario();
               p.setUsuario(u.carregar(rs.getInt("usuario_idperfil")));
               p.setData_criacao(rs.getDate("dt_criacao"));
               p.setId(rs.getInt("idperfil"));
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
    public Perfil buscarPorUsuario(Usuario usuario) throws Exception {
         Perfil p= new Perfil();
        String SQL="Select * from perfil WHERE usuario_id=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            
            IDAOUsuario  usuarioDAO = new MyDAOUsuario();
            while(rs.next()){
               p.setUsuario(usuario);
               p.setNome(rs.getString("nome"));
               p.setData_criacao(rs.getDate("dt_criacao"));
               p.setId(rs.getInt("idperfil"));
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
    public Perfil buscarPorNome(String nome) throws Exception {
         Perfil p= null;
        String SQL="Select * FROM perfil WHERE nome = ?";
        try {
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            IDAOUsuario usuarioN = new MyDAOUsuario();
            while(rs.next()){
               p=new Perfil();
               p.setId(rs.getInt("idperfil"));
               p.setUsuario(usuarioN.carregar(rs.getInt("usuario_id")));
               p.setNome(rs.getString("nome"));
               p.setData_criacao(rs.getDate("dt_criacao"));
               p.setCredito(rs.getInt("credito"));
            
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return p;
    } 

//    @Override
//    public Set<Perfil> listar() throws Exception {
//        Set<Perfil> ps= new HashSet();
//        String SQL="Select * from `perfil` p";
//        try {
//            
//            
//            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
//            ResultSet rs = stmt.executeQuery();
//            
//            while(rs.next()){
//                
//               Perfil p = new Perfil();
//               IDAOUsuario udao = new MyDAOUsuario();
//               p.setId(rs.getInt("`p.id`"));
//               p.setUsuario(udao.carregar(rs.getInt("`usuario_id`")));
//               p.setNome(rs.getString("nome"));
//               p.setData_criacao(rs.getDate("`p.data_criada`"));
//               p.setCredito(rs.getInt("`p.credito`"));
//               p.setAtivo(rs.getBoolean("`passivo`"));
//               
//               ps.add(p);
//               
//            }
//            
//           } catch (SQLException e) {
//               throw new RuntimeException(e);
//        }finally{
//          this.connection.close();
//        }
//        
//        return ps;
//    } 

}
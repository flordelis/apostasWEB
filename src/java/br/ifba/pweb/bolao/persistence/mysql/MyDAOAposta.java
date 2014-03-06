/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.mysql;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import br.ifba.pweb.bolao.persistence.IDAOPartida;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class MyDAOAposta implements IDAOAposta{

    private final Connection connection;
    public MyDAOAposta() {
        this.connection= new ConnexaoFactory().getConnection();
    }

    
    
    @Override
    public void salvar(Aposta a) throws SQLException{
        String sql="INSERT INTO `aposta` (`perfil_id`,`partida_id`,`palpite1`,`palpite2`) VALUES\n" +
                   " (?,?,?,?);";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setInt(1, a.getJogador().getId());
         stmt.setInt(2, a.getPartida().getId());
         stmt.setInt(3, a.getPalpite1());
         stmt.setInt(4, a.getPalpite2());
         
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
    public void atualizar(Aposta a) throws Exception {
       String SQL="Update `aposta` SET `status`=? WHERE `perfil_id`=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(SQL);
            stmt.setString(1, a.getStatus());
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
       
    }

    @Override
    public Aposta carregar(int id) throws Exception {
        Aposta a = new Aposta();
      
        String SQL="Select * from `aposta` WHERE `id`=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
              
               
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
            
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return a;
    } 
    
    

    @Override
    public Set<Aposta> buscarPorIdPartida(int idPartida) throws Exception {
        
        Set<Aposta> as=new HashSet();
    
               
        String SQL="Select * from `aposta` WHERE `partida_id`=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idPartida);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                         
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               Aposta a = new Aposta();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
               as.add(a);
          
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return as;
    } 

    @Override
    public Set<Aposta> carregarPorIdPerfil(int idperfil) throws Exception {
        Set<Aposta> as=new HashSet();

               
        String SQL="Select * from `aposta` WHERE `perfil_id`=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idperfil);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                             
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               Aposta a = new Aposta();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
               as.add(a);
          
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return as;
    } 

    @Override
    public Aposta buscarPorPerfilAndPartida(int idperfil, int idpartida) throws Exception {
        Aposta a= new Aposta();
                    
        String SQL="Select * from `aposta` WHERE `partida_id`=? AND `perfil_id`=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idpartida);
             stmt.setInt(1, idperfil);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                      
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               
                             
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
                   
               }           
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return a;
    } 

    @Override
    public Set<Aposta> recuperarPeloStatus(String status) throws Exception {
       Set<Aposta> as=new HashSet();
                      
        String SQL="Select * from `aposta` WHERE `status`=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                           
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               Aposta a = new Aposta();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
               as.add(a);
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
       return as;
    } 

    @Override
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil) throws Exception {
        Set<Aposta> as=new HashSet();
                  
        String SQL="Select * from `aposta` WHERE `status`=? AND `idPerfil`=?";
        
        try {            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idPerfil);
            stmt.setInt(2, idPerfil);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                           
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
              
               Aposta a = new Aposta();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
               as.add(a);
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return as;
    } 

   

    @Override
    public Set<Aposta> recuperarTodos() throws Exception {
        Set<Aposta> as=new HashSet();
                  
        String SQL="Select * from `aposta`";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                       
               IDAOPartida pdao= new MyDAOPartida();
               IDAOPerfil pfdao= new MyDAOPerfil();
               Aposta a = new Aposta();
               
               a.setId(rs.getInt("id"));
               a.setJogador(pfdao.carregar(rs.getInt("`perfil_id`")));
               a.setPartida(pdao.recuperarPeloId(rs.getInt("`partida_id`")));
               a.setPalpite1(rs.getInt("`palpite1`"));
               a.setPalpite2(rs.getInt("`palpite2`"));
               a.setData_criada(rs.getDate("data_criada"));
               
               as.add(a);
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return as;
    } 
    
    

    
}

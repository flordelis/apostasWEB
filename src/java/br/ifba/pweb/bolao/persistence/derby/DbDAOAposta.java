/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Aposta;
import br.ifba.pweb.bolao.beans.Perfil;
import br.ifba.pweb.bolao.persistence.ConnexaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import br.ifba.pweb.bolao.persistence.IDAOPartida;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAOAposta implements IDAOAposta{

    private final Connection connection;
    public DbDAOAposta() {
        this.connection= new ConnexaoFactory().getConnection();
    }

    
    
    @Override
    public void salvar(Aposta a) throws SQLException{
        String sql="INSERT INTO \"aposta\" (\"id_perfil\",\"id_partida\",\"palpite1\",\"palpite2\") VALUES\n" +
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
    public void atualizarStatus(Aposta a) throws Exception {
       String SQL="Update \"aposta\" SET \"status\"=? WHERE \"id_perfil\"=?";
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
    public Aposta recuperarPorId(int id) throws Exception {
        Aposta a = null;
        int id_partida;
        int id_perfil;
        String SQL="Select * from \"aposta\" WHERE \"id\"=?";
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               id_partida=rs.getInt("id_partida");
               id_perfil=rs.getInt("id_perfil");
               
               IDAOPartida pdao= new DbDAOPartida();
               IDAOPerfil pfdao= new DbDAOPerfil();
               
               a = new Aposta(pfdao.recuperarPeloId(id_perfil),pdao.recuperarPeloId(id_partida), rs.getInt("palpite1"), rs.getInt("palpite2"));
               a.setData_criada(rs.getDate("data_criada"));
               a.setId(rs.getInt("id"));
            
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return a;
    } 
    
    @Override
    public Set<Aposta> recuperarPelaData(Date data) throws Exception {
        Set<Aposta> a=new HashSet();
        int id_partida;
        int id_perfil;
        
        String SQL="Select * from \"aposta\" WHERE \"data_criada\"=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setDate(1, data);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               id_partida=rs.getInt("id_partida");
               id_perfil=rs.getInt("id_perfil");
               
               IDAOPartida pdao= new DbDAOPartida();
               IDAOPerfil pfdao= new DbDAOPerfil();
               
               a.add(new Aposta(pfdao.recuperarPeloId(id_perfil),pdao.recuperarPeloId(id_partida), rs.getInt("palpite1"), rs.getInt("palpite2")));
               for(Aposta ap:a){
               ap.setData_criada(data);
               ap.setId(rs.getInt("id"));
               }
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return a;
    } 
    

    @Override
    public Set<Aposta> recuperarPelaIdPartida(int idPartida) throws Exception {
        
        Set<Aposta> a=new HashSet();
        int id_perfil;
        Calendar cal;
        cal.getInstance();
        String SQL="Select * from \"aposta\" WHERE \"id_partida\"=?";
        
        try {
            
            
            PreparedStatement stmt = this.connection.prepareStatement(SQL);      
            stmt.setInt(1, idPartida);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               id_perfil=rs.getInt("id_perfil");
               
               IDAOPartida pdao= new DbDAOPartida();
               IDAOPerfil pfdao= new DbDAOPerfil();
               
               a.add(new Aposta(pfdao.recuperarPeloId(id_perfil),pdao.recuperarPeloId(idPartida), rs.getInt("palpite1"), rs.getInt("palpite2")));
               for(Aposta ap:a){
               ap.setData_criada(rs.getDate("data_criada"));
               ap.setId(rs.getInt("id"));
               }
            }
            
           } catch (SQLException e) {
               throw new RuntimeException(e);
        }finally{
          this.connection.close();
        }
        
        return a;
    } 
    
    

    @Override
    public Set<Aposta> recuperarPeloIdPerfil(int idPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloIdPerfilAndData(int idPerfil, Calendar Date) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloIdPerfilAndPartida(int idPerfil, int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatus(String status) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatusAndData(String status, Calendar data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}

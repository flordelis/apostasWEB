/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Partida;
import br.ifba.pweb.bolao.model.ConvesorData;
import br.ifba.pweb.bolao.persistence.IDAONacao;
import br.ifba.pweb.bolao.persistence.IDAOPartida;
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
public class DbDAOPartida implements IDAOPartida{
    
    Connection connection;
    
    public DbDAOPartida() {
        connection = new ConnexaoFactory().getConnection();
    }

    @Override
    public void salvar(Partida p) throws Exception {
        String sql="INSERT INTO \"partida\" (\"fase\",\"id_sede\",\"id_nacao\",\"id_adversario\",\"data\",\"horario\") VALUES " +
"(?,?,?,?,?,?)";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, p.getFase());
         stmt.setInt(2, p.getSede().getId());
         stmt.setInt(3, p.getAdver1().getId());
         stmt.setInt(4, p.getAdver2().getId());
         stmt.setDate(5, new java.sql.Date(p.getData().getTimeInMillis()));
         stmt.setTime(6, p.getHorario());
                 
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
    public Partida recuperarPeloId(int id) throws Exception {
        Partida p=null;
        
         String sql="SELECT FROM \"partida\" WHERE \"id\"=?";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
             while(rs.next()) {
                 IDAONacao ndao= new DbDAONacao();
                 IDAOSede sdao = new DbDAOSede();
                 
              p= new Partida(rs.getString("\"fase\""), sdao.recuperarpeloId(rs.getInt("\"id_sede\"")),ConvesorData.DateToCalendar(rs.getDate("\"data\"")),rs.getTime("\"horario\""),ndao.recuperarPeloId(rs.getInt("\"id_nacao\"")), ndao.recuperarPeloId(rs.getInt("\"id_adversaria\"")));
              p.setId(id);
              p.setPlacar1(rs.getInt("\"placar1\""));
              p.setPlacar2(rs.getInt("\"placar2\""));
                  
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
        
        return p;
    }
    
     @Override
    public Set<Partida> recuperarPelaFase(String fase) throws Exception {
        Set<Partida> p=null;
        
         String sql="SELECT * FROM \"partida\" WHERE \"fase\"=?";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
         stmt.setString(1, fase);
            ResultSet rs = stmt.executeQuery();
             while(rs.next()) {
                 IDAONacao ndao= new DbDAONacao();
                 IDAOSede sdao = new DbDAOSede();
                 
              p.add(new Partida(rs.getString("\"fase\""), sdao.recuperarpeloId(rs.getInt("\"id_sede\"")),ConvesorData.DateToCalendar(rs.getDate("\"data\"")),rs.getTime("\"horario\""),ndao.recuperarPeloId(rs.getInt("\"id_nacao\"")), ndao.recuperarPeloId(rs.getInt("\"id_adversaria\""))));
              for (Partida pa:p){
              pa.setId(rs.getInt("\"id\""));
              pa.setPlacar1(rs.getInt("\"placar1\""));
              pa.setPlacar2(rs.getInt("\"placar2\""));
              }
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
        
        return p;
    }

    @Override
    public Set<Partida> recuperarTodos() throws Exception {
          Set<Partida> p=null;
        
         String sql="SELECT * FROM \"partida\"";
        try{
         PreparedStatement stmt = connection.prepareStatement(sql); 
            ResultSet rs = stmt.executeQuery();
             while(rs.next()) {
                 IDAONacao ndao= new DbDAONacao();
                 IDAOSede sdao = new DbDAOSede();
                 
              p.add(new Partida(rs.getString("\"fase\""), sdao.recuperarpeloId(rs.getInt("\"id_sede\"")),ConvesorData.DateToCalendar(rs.getDate("\"data\"")),rs.getTime("\"horario\""),ndao.recuperarPeloId(rs.getInt("\"id_nacao\"")), ndao.recuperarPeloId(rs.getInt("\"id_adversaria\""))));
              for (Partida pa:p){
              pa.setId(rs.getInt("\"id\""));
              pa.setPlacar1(rs.getInt("\"placar1\""));
              pa.setPlacar2(rs.getInt("\"placar2\""));
              }
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
        
        return p;
    }

   
    
}

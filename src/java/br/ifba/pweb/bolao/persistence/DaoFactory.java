/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.persistence.mysql.MyDAOAposta;
import br.ifba.pweb.bolao.persistence.mysql.MyDAONacao;
import br.ifba.pweb.bolao.persistence.mysql.MyDAOPartida;
import br.ifba.pweb.bolao.persistence.mysql.MyDAOPerfil;
import br.ifba.pweb.bolao.persistence.mysql.MyDAOSede;
import br.ifba.pweb.bolao.persistence.mysql.MyDAOUsuario;

/**
 *
 * @author lisy
 */
public class DaoFactory {
    
    public static IDAOUsuario criarUsuarioDAO(){
          return  new MyDAOUsuario();
    }
    
    public static IDAOPerfil criarPerfilDAO(){
      return new MyDAOPerfil();
    }
    
    public static IDAONacao criarNacaoDAO(){
    return new MyDAONacao();
    }
    
    public static IDAOSede criarSedeDAO(){
      return new MyDAOSede();
    }
    
    
    public static IDAOPartida criarPartidaDAO(){
      return new MyDAOPartida();
    }
    
     public static IDAOAposta criarApostaDAO(){
      return new MyDAOAposta();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.model;

import br.ifba.pweb.bolao.beans.Aposta;
import br.ifba.pweb.bolao.beans.Partida;
import br.ifba.pweb.bolao.beans.Perfil;
import br.ifba.pweb.bolao.persistence.derby.DbDAOAposta;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class CalculadoraDeApostas{
    
    IDAOAposta adao;
    Set<Aposta> apostas;
    Partida partida;

    public CalculadoraDeApostas(Partida partida) throws Exception {
      IDAOAposta adao= new DbDAOAposta();  
      apostas= (Set<Aposta>) adao.recuperarPelaIdPartida(partida.getId());
        
    }
  
    
    
    public Set<Perfil> calculaVencedor() throws Exception{
        Set<Perfil> vencedores= new HashSet();
             
       for(Aposta aposta: apostas){
        if((partida.getPlacar1()==aposta.getPalpite1()) && (partida.getPlacar2()==aposta.getPalpite2()))
       {
           vencedores.add(aposta.getJogador());
       }
       }
       
       for(Aposta aposta: apostas){
          if(vencedores.isEmpty()) {
             if((partida.getPlacar1()>partida.getPlacar2())&&(aposta.getPalpite1()>aposta.getPalpite2()))
                 vencedores.add(aposta.getJogador());
             else if((partida.getPlacar1()==partida.getPlacar2())&&(aposta.getPalpite1()==aposta.getPalpite2()))
                 vencedores.add(aposta.getJogador());
             else if ((partida.getPlacar1()<partida.getPlacar2())&&(aposta.getPalpite1()<aposta.getPalpite2()))          
                vencedores.add(aposta.getJogador());
         }     
       }
      for(Aposta aposta: apostas){
          for(Perfil vencedor:vencedores){
          if(aposta.getJogador().getId()==vencedor.getId()){
          adao.alteraStatusPeloIdPerfil("ganhou", aposta.getJogador().getId());
          }
          else{
          adao.alteraStatusPeloIdPerfil("perdeu", aposta.getJogador().getId());
                  }
      }
      }
       
       
    return vencedores;
    }
    
  }

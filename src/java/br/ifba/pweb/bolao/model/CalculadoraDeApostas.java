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
import br.ifba.pweb.bolao.persistence.mysql.MyDAOAposta;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class CalculadoraDeApostas implements ICalculadoraApostas{
    
    IDAOAposta adao;
    Set<Aposta> apostas;
    Partida partida;

    public CalculadoraDeApostas(Partida partida) throws Exception {
      adao= new MyDAOAposta();  
      apostas= (Set<Aposta>) adao.recuperarPelaIdPartida(partida.getId());
        
    }
  
    
    
    @Override
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
          aposta.getJogador().setStatus("ganhou");
          }
          else{
          aposta.getJogador().setStatus("perdeu");
          }
          
          adao.atualizarStatus(aposta);
      }
      }
       
       
    return vencedores;
    }
    
  }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.base.Perfil;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lisy
 */
@ManagedBean(name = "CalculadoraApostas")
public final class CalculadoraDeApostasSimples implements ICalculadoraApostas{
    
   
    IDistribuidorRecompensa distribuidor;

    public CalculadoraDeApostasSimples() throws Exception {
    distribuidor = new DistribuidorRecompensaValorFixo();
    }
  
    
    
    @Override
     public Set<Perfil> calculaVencedor(Partida partida) throws Exception{
        Set<Aposta> apostas;
        NAposta apostaN = new NAposta();
        apostas= apostaN.buscarPorIdPartida(partida.getId());
        NPerfil perfilN = new NPerfil();
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
       
       distribuidor.distribuir(vencedores, partida);
       for(Perfil vencedor:vencedores){
            perfilN.salvar(vencedor);
          
       }
       
      for(Aposta aposta: apostas){
          for(Perfil vencedor:vencedores){
             
          if(aposta.getJogador().getId()==vencedor.getId()){
          aposta.setStatus("ganhou");
          }
          else{
          aposta.setStatus("perdeu");
          }
          
          
          apostaN.salvar(aposta);
          
          
        }
      }
              
    return vencedores;
    }
    
  }

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

/**
 *
 * @author lisy
 */

public final class CalculadoraDeApostasSimples {
    
  
    Set<Perfil> vencedores;
    Partida partida;
    private int valorTotal;
    private int recompensa;
   

    public CalculadoraDeApostasSimples(Partida partida) throws Exception {
    //distribuidor = new DistribuidorRecompensaValorFixo();
    vencedores= new HashSet();
    this.partida=partida;
    calculaValorTotal();
    calculaRecompensa();
    }
  
    public void calculaVencedor() throws Exception{      
        
        
        
       for(Aposta aposta: partida.getApostas()){
        if((partida.getPlacar1()==aposta.getPalpite1()) && (partida.getPlacar2()==aposta.getPalpite2()))
       {
           vencedores.add(aposta.getJogador());
       }
       }
       
       for(Aposta aposta: partida.getApostas()){
          if(vencedores.isEmpty()) {
             if((partida.getPlacar1()>partida.getPlacar2())&&(aposta.getPalpite1()>aposta.getPalpite2()))
                 vencedores.add(aposta.getJogador());
             else if((partida.getPlacar1()==partida.getPlacar2())&&(aposta.getPalpite1()==aposta.getPalpite2()))
                 vencedores.add(aposta.getJogador());
             else if ((partida.getPlacar1()<partida.getPlacar2())&&(aposta.getPalpite1()<aposta.getPalpite2()))          
                vencedores.add(aposta.getJogador());
         }     
       }
       
              
       
      for(Aposta aposta: partida.getApostas()){
          for(Perfil vencedor:vencedores){
             
          if(aposta.getJogador().getId()==vencedor.getId()){
          aposta.setStatus("ganhou");
          }
          else{
          aposta.setStatus("perdeu");
          }
          
          NAposta apostaN = new NAposta();
          apostaN.salvar(aposta);
          }    
          
      }
     }
   
      public void distribuir() throws Exception {        
            for(Perfil vencedor: vencedores){
              vencedor.addCredito(recompensa);
              
            }
            for(Perfil vencedor:vencedores){
            NPerfil perfilN = new NPerfil();    
            perfilN.salvar(vencedor);
             
           }
    }
         
    private void calculaRecompensa(){
      this.recompensa=this.valorTotal/vencedores.size();
    }
    
  
    
    private void calculaValorTotal(){
       
       for(Aposta a:partida.getApostas()){
         this.valorTotal+=5;
       }
    
        }
}

    


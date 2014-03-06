/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.base.Perfil;

import java.util.Set;

/**
 *
 * @author lisy
 */
public final class DistribuidorRecompensaValorFixo implements IDistribuidorRecompensa {
    
     private int valorTotal;
    

    public DistribuidorRecompensaValorFixo() throws Exception {
        
        this.valorTotal=0;
       
        
    }
    
    
     @Override
        public void distribuir(Set<Perfil> vencedores, Partida partida) throws Exception{
        
            for(Perfil vencedor: vencedores){
           
             vencedor.addCredito(this.calculaRecompensa(vencedores, partida));
             
           }
    }
      
       
    private int calculaRecompensa(Set<Perfil> vencedores, Partida partida) throws Exception{
    this.calculaValorTotal(partida.getId());
    return this.valorTotal/vencedores.size();
    }
    
    private void calculaValorTotal(int id) throws Exception{
        NAposta apostaN = new NAposta ();
        Set<Aposta> apostas=apostaN.buscarPorIdPartida(id);
       for(Aposta aposta:apostas){
         valorTotal+=5;
       }
    
    }

    
    
}

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
import br.ifba.pweb.bolao.persistence.derby.DbDAOPerfil;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DistribuidorRecompensa {
    
    private final Set <Perfil> vencedores;
    IDAOAposta adao;
    private int valorTotal;
    private final Partida partida;
    Set<Aposta> apostas;
    int recompensa;
    IDAOPerfil pdao;

    public DistribuidorRecompensa(Set <Perfil> vencedores, Partida partida) throws Exception {
        this.vencedores=vencedores;
        this.partida=partida;
        adao= new DbDAOAposta();
        apostas=adao.recuperarPelaIdPartida(partida.getId());
        this.valorTotal=0;
        this.calculaValorTotal();
        this.calculaRecompensa();
        
    }
    
    
    public void distribuir() throws Exception{
         pdao= new DbDAOPerfil();
         for(Perfil vencedor: vencedores){
              pdao.altualizarCredito(recompensa, vencedor);
        }
    }
      
       
    private void calculaRecompensa(){
    this.recompensa=this.valorTotal/vencedores.size();
    }
    
    private void calculaValorTotal() throws Exception{
    
       for(Aposta aposta:apostas){
         valorTotal+=5;
       }
    
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.persistence.DaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DistribuidorRecompensa {
    
    private final Set <Perfil> vencedores;
    IDAOAposta apostaDAO;
    private int valorTotal;
    private final Partida partida;
    Set<Aposta> apostas;
    int recompensa;
    IDAOPerfil perfilDAO;

    public DistribuidorRecompensa(Set <Perfil> vencedores, Partida partida) throws Exception {
        this.vencedores=vencedores;
        this.partida=partida;
        apostaDAO= DaoFactory.criarApostaDAO();
        apostas=apostaDAO.recuperarPelaIdPartida(partida.getId());
        this.valorTotal=0;
        this.calculaValorTotal();
        this.calculaRecompensa();
        
    }
    
    
    public void distribuir() throws Exception{
         perfilDAO= DaoFactory.criarPerfilDAO();
         for(Perfil vencedor: vencedores){
              perfilDAO.altualizarCredito(recompensa, vencedor);
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

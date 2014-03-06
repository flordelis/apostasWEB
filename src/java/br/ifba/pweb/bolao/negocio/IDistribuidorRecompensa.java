/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.base.Perfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDistribuidorRecompensa {

   public  void distribuir(Set<Perfil> vencedores, Partida partida) throws Exception;
    
}

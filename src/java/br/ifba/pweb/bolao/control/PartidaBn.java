/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.control;

import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.negocio.NPartida;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author helisla
 */
public class PartidaBn {

    /**
     * Creates a new instance of PartidaBn
     */
    Set<Partida> partidas;
    public PartidaBn() {
        partidas= new HashSet();
        try {
            carregaPartidas();
        } catch (Exception ex) {
            Logger.getLogger(PartidaBn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Set<Partida> getPartidas() {
         return partidas;
    }

    public final void carregaPartidas() throws Exception {
        NPartida partida = new NPartida();
        this.partidas = partida.listar(null);
    }
    
    
    
    
}

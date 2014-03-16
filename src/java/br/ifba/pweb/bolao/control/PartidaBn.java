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
import javax.faces.bean.ManagedBean;

/**
 *
 * @author helisla
 */
@ManagedBean


public class PartidaBn {

    /**
     * Creates a new instance of PartidaBn
     */
    Set<Partida> partidas;
    String fase;
    Partida partida;
    
    public PartidaBn() {
        partidas= new HashSet();
     
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Set<Partida> getPartidas() {
         return partidas;
    }

    public Set<Partida> carregaPartidas(String fase, String grupo) throws Exception {
        NPartida partidaN = new NPartida();
        Set<Partida> partidasf = partidaN.listar(fase);
        for(Partida pa:partidasf)
        { if(pa.getAdver1().getGrupo().equals(grupo))
            partidas.add(pa);
            }
    return partidas;
        }
}


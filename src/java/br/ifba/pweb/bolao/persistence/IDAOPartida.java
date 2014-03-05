/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Partida;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOPartida {
    
    public void salvar(Partida p) throws Exception;
    public Partida recuperarPeloId(int id)throws Exception;
    public Set<Partida> recuperarPelaFase(String fase)throws Exception;
    public Set<Partida> recuperarTodos()throws Exception;
    
}

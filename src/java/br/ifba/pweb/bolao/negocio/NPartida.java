/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Partida;
import br.ifba.pweb.bolao.persistence.DaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOPartida;
import java.util.Set;

/**
 *
 * @author helisla
 */

public class NPartida {
    IDAOPartida partidaDAO;

    public NPartida() {
        this.partidaDAO = DaoFactory.criarPartidaDAO();
    }
    
    public Set<Partida> listar(String fase) throws Exception{
        
        return partidaDAO.recuperarPelaFase(fase);
    
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.persistence.DaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class NAposta {
    
    IDAOAposta apostaDAO;
    
    public NAposta(){
       apostaDAO=DaoFactory.criarApostaDAO();
    }

    public Set<Aposta> buscarPorIdPartida(int idPartida) throws Exception {
        return apostaDAO.buscarPorIdPartida(idPartida);
    }
    
     public Set<Aposta> buscarPorIdPerfil(int idPerfil) throws Exception {
        return apostaDAO.carregarPorIdPerfil(idPerfil);
    }

    public void salvar(Aposta aposta) throws Exception {
        Integer codigo = aposta.getId();
		if (codigo == null || codigo == 0) {

			this.apostaDAO.salvar(aposta);


		} else {
			this.apostaDAO.atualizar(aposta);
		}
    }
    
}

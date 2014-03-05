/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Nacao;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAONacao {
     public Nacao recuperarPeloId(int id)throws Exception;
     public Set<Nacao> recuperarTodos()throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Nacao;
import br.ifba.pweb.bolao.persistence.IDAONacao;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAONacao implements IDAONacao{

    @Override
    public Set<Nacao> recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

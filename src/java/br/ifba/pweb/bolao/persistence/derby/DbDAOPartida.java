/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Partida;
import br.ifba.pweb.bolao.persistence.ConnexaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOPartida;
import java.sql.Connection;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAOPartida implements IDAOPartida{
    
    Connection connection;
    
    public DbDAOPartida() {
        connection = new ConnexaoFactory().getConnection();
    }

    @Override
    public void salvar(Partida p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Partida recuperarPeloId(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Partida> recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

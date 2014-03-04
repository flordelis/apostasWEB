/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Perfil;
import br.ifba.pweb.bolao.beans.Usuario;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAOPerfil implements IDAOPerfil{

    @Override
    public void salvar(Perfil p, Usuario u) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void altualizarCredito(int valor, Perfil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil recuperarPeloIdUsuario(int iduser) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Perfil> recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

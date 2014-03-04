/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence.derby;

import br.ifba.pweb.bolao.beans.Aposta;
import br.ifba.pweb.bolao.persistence.IDAOAposta;
import java.util.Calendar;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class DbDAOAposta implements IDAOAposta{

    
    
    @Override
    public void salvar(Aposta a) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alteraStatusPeloIdPerfil(String status, int idPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPelaData(Calendar Date) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPelaIdPartida(int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloIdPerfil(int idPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloIdPerfilAndData(int idPerfil, Calendar Date) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloIdPerfilAndPartida(int idPerfil, int idPartida) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatus(String status) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarPeloStatusAndData(String status, Calendar data) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Aposta> recuperarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

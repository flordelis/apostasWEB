/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Perfil;
import br.ifba.pweb.bolao.beans.Usuario;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOPerfil {
    
    public void salvar(Perfil p, Usuario u) throws Exception;
    public Perfil recuperarPeloIdUsuario(int iduser)throws Exception;
    public Set<Perfil> recuperarTodos()throws Exception;	
    
}

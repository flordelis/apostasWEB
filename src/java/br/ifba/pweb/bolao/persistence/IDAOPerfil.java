/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.base.Usuario;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOPerfil {
    
    public void salvar(Perfil p) throws Exception;
    public void atualizar(Perfil p)throws Exception;
    public Perfil carregar(int id)throws Exception;
    public Perfil buscarPorIdUsuario(int iduser)throws Exception;
    public Perfil buscarPorNome(String nome)throws Exception;
   // public Set<Perfil> listar() throws Exception;  
}

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
public interface IDAOUsuario {
    public void salvar(Usuario u) throws Exception;
    public void removerPeloLoginSenha(Usuario u)throws Exception;
    public Usuario recuperarPeloLoginSenha(String login, String Senha)throws Exception;

    
}


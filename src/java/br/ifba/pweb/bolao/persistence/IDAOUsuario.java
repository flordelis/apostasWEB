/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.base.Usuario;
import java.sql.SQLException;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOUsuario {
    public void salvar(Usuario u) throws Exception;
    public void atualizar(Usuario u) throws Exception;
    public void excluir(Usuario u) throws Exception;
    public Usuario carregar(Integer codigo) throws Exception;
    public Usuario buscarPorLogin(String login) throws Exception;
    public Set<Usuario> listar() throws Exception;

}


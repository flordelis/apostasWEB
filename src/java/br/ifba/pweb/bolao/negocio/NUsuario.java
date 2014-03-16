/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;

import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.persistence.DaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOUsuario;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class NUsuario {


	private IDAOUsuario usuarioDAO;

	public NUsuario() {
		this.usuarioDAO = DaoFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) throws Exception {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) throws Exception {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) throws Exception {

		Integer codigo = usuario.getId();
		if (codigo == null || codigo == 0) {

			usuario.setPermissao("ROLE_USUARIO");

			this.usuarioDAO.salvar(usuario);


		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) throws Exception {
		
            	this.usuarioDAO.excluir(usuario);
	}

	public Set<Usuario> listar() throws Exception {
		return this.usuarioDAO.listar();
	}

}
 
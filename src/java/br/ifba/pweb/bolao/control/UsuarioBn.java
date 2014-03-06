/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.control;

import br.ifba.pweb.bolao.negocio.NPerfil;
import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.negocio.NUsuario;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author lisy
 */

@ManagedBean
public class UsuarioBn {
    
        private Usuario	usuario;
	private String confirmarSenha;
	private Set<Usuario> lista;
	private String	permissao;
	private Perfil perfil;

	public String novo() {
		this.usuario = new Usuario();
                this.perfil= new Perfil();
		return "usuario";
	}

	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public String salvar() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		NUsuario usuarioRN = new NUsuario();
		usuarioRN.salvar(this.usuario);

		if (!this.perfil.getNome().isEmpty()) {
			this.perfil.setUsuario(this.usuario);
                        NPerfil perfilRN = new NPerfil();
                        perfilRN.salvar(this.perfil);
		}
             return "salvo com sucesso";   
        }	
     public String excluir() throws Exception {
		NUsuario usuarioRN = new NUsuario();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	
      public Set <Usuario> getLista() throws Exception {
		if (this.lista == null) {
			NUsuario usuarioRN = new NUsuario();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	
	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}

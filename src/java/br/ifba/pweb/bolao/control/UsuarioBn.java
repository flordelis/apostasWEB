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
	private String destinoSalvar;
	private String	permissao;
	private Perfil conta;

	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
                this.conta= new Perfil();
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

		if (!this.conta.getNome().isEmpty()) {
			this.conta.setUsuario(this.usuario);
                        NPerfil contaRN = new NPerfil();
                        contaRN.ativar(this.conta);
			contaRN.salvar(this.conta);
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

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	public Perfil getConta() {
		return conta;
	}

	public void setConta(Perfil conta) {
		this.conta = conta;
	}
}

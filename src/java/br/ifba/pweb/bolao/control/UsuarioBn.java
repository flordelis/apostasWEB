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
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author lisy
 */

@ManagedBean
public class UsuarioBn {
    
        private Usuario	usuario;
	private String confirmarSenha;
        private String login;
	private Set<Usuario> lista;
	private Perfil perfil;
        public static final String USER_SESSION_KEY = "user";

    public UsuarioBn() {
        
        this.usuario = new Usuario();
        this.lista = new HashSet();
    }
        
         public String validaUsuario() throws Exception {   
        FacesContext context = FacesContext.getCurrentInstance();
        
        Usuario user = getUsuario();
        if (user != null) {
            if (!user.getSenha().equals(confirmarSenha)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Login Falhou!",
                                           "A senha não esta correta.");
                context.addMessage(null, message);
                return null;
            }
            PerfilBn perfilBn= new PerfilBn();
            perfilBn.carregarbyIDUser(user.getId());
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            
            if(user.getPermissao().equals("ROLE_USER"))
            return "app-main-user";
            else 
            return "app-main-admin";    
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Falhou!",
                    "Usuario '"
                    + login
                    +
                    "' não existe.");
            context.addMessage(null, message);
            return null;
        }
    }
         
      public String logout() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";
        
    }    
            
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

	public Usuario getUsuario() throws Exception {
	 try {
           NUsuario usuarioRN = new NUsuario();
           return usuarioRN.buscarPorLogin(login); 
        } catch (SQLException e) {
            return null;
        }
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

	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

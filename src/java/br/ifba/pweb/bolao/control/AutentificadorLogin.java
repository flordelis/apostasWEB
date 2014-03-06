/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.control;

import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.negocio.NUsuario;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lisy
 */
@ManagedBean
public class AutentificadorLogin {
    String login;
    String senha;
    
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
       
    
    public String autentificarUsuario() throws Exception{
        
      if(!this.senha.isEmpty()){
          NUsuario usuarioN = new NUsuario();
          Usuario usuario= usuarioN.buscarPorLogin(login);
      if(usuario.getSenha().equals(this.senha)){
          if(usuario.getPermissao().equals("ROLE_ADMIN")){
              return "/admin/principal";
              
          }else
              return "/usuario/principal";
       }else
         return "/public/login";
      }
      else
        return "erro";
    }
}

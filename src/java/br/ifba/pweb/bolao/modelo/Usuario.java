/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

import java.io.Serializable;

/**
 *
 * @author lisy
 */
public class Usuario implements  Serializable{
    private int id;
    private String login;
    private String senha;
    private final String permissao;
 
    
   
   public Usuario(String login, String senha, String permissao) {
        this.login = login;
        this.senha = senha;
        this.permissao=permissao;
   }
   
   public Usuario(int id,String login, String senha, String permissao) {
        this.id=id;
        this.login = login;
        this.senha = senha;
        this.permissao=permissao;
   }
  
   
    public boolean isAdmin(){
      return permissao.equalsIgnoreCase("ROLE_ADMIN");   
    }

    public int getId() {
        return id;
    }
 
        
    public String getLogin() {
        return login;
    }

    public String getPermissao() {
        return permissao;
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

    public void setPermissao(String role_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 }

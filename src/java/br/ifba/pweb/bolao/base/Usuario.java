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
    private String permissao;

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", permissao=" + permissao + '}';
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPermissao(String permissao) {
        this.permissao=permissao;
    }

 }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.beans;

/**
 *
 * @author lisy
 */
public class Usuario {
    private final int id;
    private int login;
    private String senha;
    private final Perfil perfil;

    public Usuario(int id, int login, String senha, Perfil perfil) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil + '}';
    }

    public int getId() {
        return id;
    }
 
    
    public Perfil getPerfil() {
        return perfil;
    }
    
    public int getLogin() {
        return login;
    }

    public void setLogin(int login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
 }

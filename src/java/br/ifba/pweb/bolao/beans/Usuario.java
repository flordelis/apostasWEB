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
    private int id;
    private String login;
    private String senha;
    private String papel;
    private Perfil perfil;
    
    public Usuario(int id){
    this.id=id;
    }

    public Usuario(String login, String senha, Perfil perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }
   public Usuario(String login, String senha, char papel) {
        this.login = login;
        this.senha = senha;
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
    
    public String getLogin() {
        return login;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
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

    public void setPerfil(Perfil recuperarPeloId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

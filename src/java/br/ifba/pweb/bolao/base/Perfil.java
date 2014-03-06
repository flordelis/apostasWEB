/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

import java.sql.Date;
import java.util.Set;


/**
 *
 * @author lisy
 */
public class Perfil {
    private int id;
    private String nome;
    private int credito;
    private  Date data_criacao;
    private Set<Aposta> apostas;
    private boolean ativo;
    private Usuario usuario;
    
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
       // this.data_criacao = data_criacao;
        data_criacao= new Date(2044,13,13);
    }

    public Set<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(Set<Aposta> apostas) {
        this.apostas = apostas;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void addCredito(int valor) {
     this.credito+=valor;
    }
 
    
}

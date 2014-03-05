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

    
    public Perfil(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Set<Aposta> getApostas() {
        return apostas;
    }

    public void addCredito(int valor){
      this.credito+=valor;
    }
    
    public String addApostas(Aposta aposta){
     if(this.credito>0){
    apostas.add(aposta);
    this.credito-=5;
    return "Operação feita com sucesso";
    }
    else{
    return "Compre mais credito";
    }
    }

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + ", credito=" + credito + ", data_criacao=" + data_criacao + ", apostas=" + apostas + ", ativo=" + ativo + ", usuario=" + usuario + '}';
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

    public int getId() {
        return id;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setAtivo(String ganhou) {
     this.ativo=true;
    }

    public void setUsuario(Usuario usuario) {
     this.usuario=usuario;
    }
    
    
    
}
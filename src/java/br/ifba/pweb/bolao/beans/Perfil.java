/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

/**
 *
 * @author lisy
 */
public class Perfil {
    private final int id;
    private String nome;
    private int credito;
    private final Calendar data_criacao;
    private List<Aposta> apostas;

    
    public Perfil(int id, String nome, int credito, Calendar data_criacao) {
        this.id = id;
        this.nome = nome;
        this.credito = credito;
        this.data_criacao = data_criacao;
        this.apostas=new ArrayList();
       
        
    }

    public List<Aposta> getApostas() {
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
    
    public void removeApostasbyID(int id){
    apostas.remove(id);
    }
    
    

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + ", credito=" + credito + ", data_criacao=" + data_criacao + ", apostas=" + apostas + '}';
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

    public Calendar getData_criacao() {
        return data_criacao;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.beans;

import java.util.Calendar;

/**
 *
 * @author lisy
 */
public class Perfil {
    private final int id;
    private String nome;
    private double credito;
    private final Calendar data_criacao;

    
    public Perfil(int id, String nome, double credito, Calendar data_criacao) {
        this.id = id;
        this.nome = nome;
        this.credito = credito;
        this.data_criacao = data_criacao;
    }

    
    
    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + ", credito=" + credito + ", data_criacao=" + data_criacao + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public int getId() {
        return id;
    }

    public Calendar getData_criacao() {
        return data_criacao;
    }
    
    
    
}

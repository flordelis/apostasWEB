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
public class Nacao {
  private  int id;
  private  String nome;  

    public Nacao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

        
    @Override
    public String toString() {
        return "Nacao{" + "id=" + id + ", nome=" + nome + '}';
    }

    public int getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }
      
}

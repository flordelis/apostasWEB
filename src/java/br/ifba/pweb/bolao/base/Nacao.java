/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

/**
 *
 * @author lisy
 */
public class Nacao {
  private  int id;
  private  String nome; 
  private String grupo;
  private String sigla;

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
        return "Nacao{" + "id=" + id + ", nome=" + nome + ", grupo=" + grupo + ", sigla=" + sigla + '}';
    }

   
    public int getId() {
        return id;
    }

    
    public String getNome() {
        return nome;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
      
}

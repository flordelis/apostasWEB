/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

import java.sql.Date;
import java.util.HashSet;
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
    private boolean ativo;
    private Usuario usuario;

    @Override
    public String toString() {
        return "Perfil{" + "id=" + id + ", nome=" + nome + ", credito=" + credito + ", data_criacao=" + data_criacao + ", ativo=" + ativo + ", usuario=" + usuario + '}';
    }

   

        
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
       this.data_criacao = data_criacao;
   
    }

//    public Set<Aposta> getApostas() {
//        return apostas;
//    }
//
//    public  String addAposta(Aposta aposta) throws Exception{
//         if(this.getCredito()>aposta.getTaxa()){
//           this.debitCredito(aposta.getTaxa());
//           this.getApostas().add(aposta);
//          return "Aposta realizada com sucesso";
//         }else{
//         return "Operacao não realizada";
//         }
//     
//    }
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

    public void debitCredito(int valor){
         this.credito -=credito;
    }
    
    
    public void addCredito(int valor) {
     this.credito+=valor;
    }
 
    
}

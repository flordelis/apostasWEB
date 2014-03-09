/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author lisy
 */
public class Aposta {
    private int id;
    private final int taxa=5;

    public int getTaxa() {
        return taxa;
    }
    private Perfil jogador;
    private Date data_criada;
    private Partida partida;
    private int palpite1;
    private int palpite2;
    private String status;

   
    @Override
    public String toString() {
        return "Aposta{" + "id=" + id + ", perfil=" + jogador + ", data_criada=" + data_criada + ", partida=" + partida + ", palpite1=" + palpite1 + ", palpite2=" + palpite2 + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfil getJogador() {
        return jogador;
    }

    public void setJogador(Perfil perfil) {
        this.jogador = perfil;
    }

    public Date getData_criada() {
        return data_criada;
    }

    public void setData_criada(Date data_criada) {
        this.data_criada = data_criada;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public int getPalpite1() {
        return palpite1;
    }

    public void setPalpite1(int palpite1) {
        this.palpite1 = palpite1;
    }

    public int getPalpite2() {
        return palpite2;
    }

    public void setPalpite2(int palpite2) {
        this.palpite2 = palpite2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

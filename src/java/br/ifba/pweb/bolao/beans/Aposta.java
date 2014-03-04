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
public class Aposta {
    private int id;
    private Perfil perfil;
    private Calendar data_criada;
    private Partida partida;
    private int palpite1;
    private int palpite2;
    private String status;

    @Override
    public String toString() {
        return "Aposta{" + "id=" + id + ", perfil=" + perfil + ", data_criada=" + data_criada + ", partida=" + partida + ", palpite1=" + palpite1 + ", palpite2=" + palpite2 + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Calendar getData_criada() {
        return data_criada;
    }

    public void setData_criada(Calendar data_criada) {
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

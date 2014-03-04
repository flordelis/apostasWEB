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
public class Partida {
    private int id;
    private String fase;
    private Sede sede;
    private Calendar data_horario;
    private Nacao adver1;
    private Nacao adver2;
    private int placar1;
    private int placar2;

    @Override
    public String toString() {
        return "Partida{" + "id=" + id + ", fase=" + fase + ", sede=" + sede + ", data_horario=" + data_horario + ", adver1=" + adver1 + ", adver2=" + adver2 + ", placar1=" + placar1 + ", placar2=" + placar2 + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    
    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Calendar getData_horario() {
        return data_horario;
    }

    public void setData_horario(Calendar data_horario) {
        this.data_horario = data_horario;
    }

    public Nacao getAdver1() {
        return adver1;
    }

    public void setAdver1(Nacao adver1) {
        this.adver1 = adver1;
    }

    public Nacao getAdver2() {
        return adver2;
    }

    public void setAdver2(Nacao adver2) {
        this.adver2 = adver2;
    }

    public int getPlacar1() {
        return placar1;
    }

    public void setPlacar1(int placar1) {
        this.placar1 = placar1;
    }

    public int getPlacar2() {
        return placar2;
    }

    public void setPlacar2(int placar2) {
        this.placar2 = placar2;
    }

    
}

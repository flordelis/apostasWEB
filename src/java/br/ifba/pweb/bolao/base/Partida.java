/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.base;

import java.sql.Time;
import java.util.Calendar;
import java.util.Set;


/**
 *
 * @author lisy
 */
public class Partida {
    private int id;
    private String fase;
    private Sede sede;
    private Calendar data;
    private Time horario;
    private Nacao adver1;
    private Nacao adver2;
    private int placar1;
    private int placar2;
    private Set<Aposta> apostas;

    public Set<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(Set<Aposta> apostas) {
        this.apostas = apostas;
    }

    public Partida(String fase, Sede sede, Calendar data, Time horario, Nacao adver1, Nacao adver2) {
        this.fase = fase;
        this.sede = sede;
        this.data = data;
        this.horario = horario;
        this.adver1 = adver1;
        this.adver2 = adver2;
        
        
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

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
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

    @Override
    public String toString() {
        return "Partida{" + "id=" + id + ", fase=" + fase + ", sede=" + sede + ", data=" + data + ", horario=" + horario + ", adver1=" + adver1 + ", adver2=" + adver2 + ", placar1=" + placar1 + ", placar2=" + placar2 + '}';
    }
    
    
    

}
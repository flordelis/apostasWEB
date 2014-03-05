/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.model;

import br.ifba.pweb.bolao.beans.Perfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface ICalculadoraApostas {

    Set<Perfil> calculaVencedor() throws Exception;
    
}
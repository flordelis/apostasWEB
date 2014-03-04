/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Sede;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOSede {
    
    public Set<Sede> recuperarTodos()throws Exception;
    
}

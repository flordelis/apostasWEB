/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Aposta;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOAposta {
    
    public void salvar(Aposta a) throws Exception;
    public void alteraStatusPeloIdPerfil(String status, int idPerfil) throws Exception;
    public Set<Aposta> recuperarPelaData(Calendar Date)throws Exception;
    public Set<Aposta> recuperarPelaIdPartida(int idPartida)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfil(int idPerfil)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfilAndData(int idPerfil, Calendar Date)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfilAndPartida(int idPerfil, int idPartida)throws Exception;
    public Set<Aposta> recuperarPeloStatus(String status)throws Exception;
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil)throws Exception;
    public Set<Aposta> recuperarPeloStatusAndData(String status, Calendar data)throws Exception;
    public Set<Aposta> recuperarTodos()throws Exception;
    
}

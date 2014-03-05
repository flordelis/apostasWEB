/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.beans.Aposta;
import br.ifba.pweb.bolao.beans.Perfil;
import java.sql.Date;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOAposta {
    
    public void salvar(Aposta a)throws Exception;
    public void atualizarStatus(Aposta a)throws Exception;
    public Aposta recuperarPorId(int id) throws Exception;
    public Set<Aposta> recuperarPelaData(Date data)throws Exception;
    public Set<Aposta> recuperarPelaIdPartida(int idpartida)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfil(int idperfil)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfilAndData(int idperfil, Date data)throws Exception;
    public Set<Aposta> recuperarPeloIdPerfilAndPartida(int idperfil, int idpartida)throws Exception;
    public Set<Aposta> recuperarPeloStatus(String status)throws Exception;
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil)throws Exception;
    public Set<Aposta> recuperarPeloStatusAndData(String status, Date data)throws Exception;
    public Set<Aposta> recuperarTodos()throws Exception;
    
}

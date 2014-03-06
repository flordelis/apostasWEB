/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.persistence;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.base.Perfil;
import java.sql.Date;
import java.util.Set;

/**
 *
 * @author lisy
 */
public interface IDAOAposta {
    
    public void salvar(Aposta a)throws Exception;
    public void atualizar(Aposta a)throws Exception;
    public Aposta carregar(int id) throws Exception;
    public Set<Aposta> buscarPorIdPartida(int idPartida)throws Exception;
    public Set<Aposta> carregarPorIdPerfil(int idPerfil)throws Exception;
    //public Set<Aposta> recuperarPeloIdPerfilAndData(int idperfil, Date data)throws Exception;
    public Aposta buscarPorPerfilAndPartida(int idPerfil, int idpartida)throws Exception;
    public Set<Aposta> recuperarPeloStatus(String status)throws Exception;
    public Set<Aposta> recuperarPeloStatusAndIdPerfil(String status, int idPerfil)throws Exception;
   //  public Set<Aposta> recuperarPeloStatusAndData(String status, Date data)throws Exception;
    public Set<Aposta> recuperarTodos()throws Exception;
    
}

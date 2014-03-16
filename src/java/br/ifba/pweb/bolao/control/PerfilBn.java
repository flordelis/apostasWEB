/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.control;

import br.ifba.pweb.bolao.base.Aposta;
import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.negocio.NAposta;
import br.ifba.pweb.bolao.negocio.NPerfil;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.util.Set;

/**
 *
 * @author lisy
 */
public class PerfilBn {

    Perfil perfil;
    Set <Aposta> apostas;
    Aposta aposta;
    
    public void carregarbyIDUser(int id) throws Exception {
        NPerfil perfilN = new NPerfil();
        perfil = perfilN.buscarPorIdUsuario(id);
        
    }
////     public Set<Aposta> adicionarApostas(Perfil perfil, Aposta aposta) throws Exception{
////            perfil.getApostas().add(aposta);
////            NAposta apostaN = new NAposta();
////            apostaN.salvar(aposta);
////        return null;
//        }
}

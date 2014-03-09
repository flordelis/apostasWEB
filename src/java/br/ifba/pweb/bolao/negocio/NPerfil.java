/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.pweb.bolao.negocio;


import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.persistence.DaoFactory;
import br.ifba.pweb.bolao.persistence.IDAOPerfil;
import java.sql.Date;



/**
 *
 * @author lisy
 */
public class NPerfil {
    
    private IDAOPerfil	perfilDAO;

	public NPerfil() {
		this.perfilDAO = DaoFactory.criarPerfilDAO();
	}

   	public Perfil carregar(Integer perfil) throws Exception {
		return this.perfilDAO.carregar(perfil);
	}

	public void salvar(Perfil perfil) throws Exception {
                long dt = System.currentTimeMillis();
		perfil.setData_criacao(new Date(dt));
		this.perfilDAO.salvar(perfil);
	}

        
    public Perfil buscarPorIdUsuario(int iduser)throws Exception{
            return this.buscarPorIdUsuario(iduser);
            
    }
    public String buscarPorNome(String nome)throws Exception{
            return this.buscarPorNome(nome);
    }
    }
   // public Set<Perfil> listar() throws Exception;  
    


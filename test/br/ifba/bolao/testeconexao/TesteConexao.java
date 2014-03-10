/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ifba.bolao.testeconexao;

import br.ifba.pweb.bolao.base.Perfil;
import br.ifba.pweb.bolao.base.Usuario;
import br.ifba.pweb.bolao.control.UsuarioBn;
import br.ifba.pweb.bolao.negocio.NPerfil;
import br.ifba.pweb.bolao.negocio.NUsuario;
import java.sql.Connection;
import br.ifba.pweb.bolao.persistence.mysql.ConnexaoFactory;
import java.sql.SQLException;
/**
 *
 * @author lisy
 */
public class TesteConexao {
    
    public static void main(String[] args) throws SQLException, Exception {
       Connection connection = new ConnexaoFactory().getConnection();
            System.out.println("Conexao Aberta");
            NUsuario un = new NUsuario();
            Usuario u= un.buscarPorLogin("lisy");
            UsuarioBn bn = new UsuarioBn();
            bn.setLogin("lisy");
            Usuario bu=bn.getUsuario();
            NPerfil perfilN = new NPerfil();
            Perfil perfil= perfilN.buscarPorIdUsuario(bu.getId());
            //Perfil perfil2= perfilN.buscarPorNome("helis");
            System.out.println(perfil);
            System.out.println(u);
            System.out.println(bu);
        connection.close();
        System.out.println("Conexao Fechada");
    }
    
}

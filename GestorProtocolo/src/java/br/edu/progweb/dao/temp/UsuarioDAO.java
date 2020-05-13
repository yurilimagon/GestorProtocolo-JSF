/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.dao.temp;

import br.edu.progweb.modelo.acesso.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yuril
 */
public class UsuarioDAO {
    private List<Usuario> tabUsuario;

    public UsuarioDAO() {
        tabUsuario = new ArrayList<>();
        povoarTabela();
    }
    
    private List<Usuario> povoarTabela() {
        Usuario user1 = new Usuario("Anderson","123@456", "A@mail.com");
        Usuario user2 = new Usuario("Marcela","333@456", "M@mail.com");
        Usuario user3 = new Usuario("João","444@456", "J@mail.com");
        tabUsuario.add(user1);
        tabUsuario.add(user2);
        tabUsuario.add(user3);
        return tabUsuario;
    }
    
    public Usuario buscarUsuario(String email){
        for(Usuario usuario : tabUsuario){
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }
}

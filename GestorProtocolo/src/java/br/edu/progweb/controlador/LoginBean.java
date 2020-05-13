/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.controlador;

import br.edu.progweb.dao.temp.UsuarioDAO;
import br.edu.progweb.modelo.acesso.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author yuril
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private UsuarioDAO dao;
    private Usuario usuario;
    
    public LoginBean() {
        dao = new UsuarioDAO();
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    //Métodos
    public String logar(){
        Usuario encontrado = dao.buscarUsuario(usuario.getEmail());
        if(usuario.logar(encontrado)){
            return "inicial";
        } else{
            String msg = "Usuário ou senha inválidos.";
            //Apagar os dados do usuario da tela
            usuario = new Usuario();
            FacesContext fc = FacesContext.getCurrentInstance();
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro ao logar", msg);
            fc.addMessage(null, fm);
            return null; 
        }           
    }
}

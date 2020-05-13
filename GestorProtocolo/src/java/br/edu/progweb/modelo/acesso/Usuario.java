/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.progweb.modelo.acesso;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author yuril
 */
public class Usuario {
    private Integer id;
    private String nome;
    private String senha;
    private String email;
    private Date dataNascimento;
    private int idade;
    private TipoUsuario tipousuario;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public void setDataNascimento(String dataNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.dataNascimento = sdf.parse(dataNascimento);
            sdf.setLenient(false);
        } catch (ParseException e) {
            System.out.println("A data informada deve ser no formato dd/mm/aaaa");
        }
    }

    /*public int getIdade() {
        return idade;
    }*/

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    //MÉTODOS   
    public int getIdade(){
        if(this.dataNascimento != null){
            Calendar dtNasc = new GregorianCalendar();
            dtNasc.setTime(this.dataNascimento);
            Calendar hoje = Calendar.getInstance();
            idade = hoje.get(Calendar.YEAR) - dtNasc.get(Calendar.YEAR);
            dtNasc.add(Calendar.YEAR, idade);
            if(hoje.before(dtNasc)){
                idade--;
            }
        }
        return idade;
    }
    
    public boolean logar(Usuario userLogin){
        if(userLogin == null){
            return false;
        }
        return userLogin.getSenha().equals(this.senha);
    }
    
    public String criptografarSenha(String senha){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1,md.digest(senha.getBytes()));
            return hash.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Não foi possível criptografar");
        }
        return this.senha;
    }
}
package org.example.srs.Models;

public class Usuario {

    private String identificador;
    private String nome;
    private String email;
    private String emailEducacional;
    private String senha;
    private String tipo;

    public Usuario() {}

    public Usuario(String id, String nome, String email, String emailEd, String senha, String tipo) {
        this.identificador = id;
        this.nome = nome;
        this.email = email;
        this.emailEducacional = emailEd;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String nome, String email, String emailEducacional, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.emailEducacional = emailEducacional;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String nome, String email, String senha, String administrador) {
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNomeCompleto() {
        return nome;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nome = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailEducacional() {
        return emailEducacional;
    }

    public void setEmailEducacional(String emailEducacional) {
        this.emailEducacional = emailEducacional;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipoUsuario() {
        return tipo;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipo = tipoUsuario;
    }
}

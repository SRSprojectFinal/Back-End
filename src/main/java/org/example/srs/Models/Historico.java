package org.example.srs.Models;

public class Historico {

    private String emailEducacional;
    private String curso;
    private String situacao;

    public Historico() {}

    public Historico(String email, String curso) {
        this.emailEducacional = email;
        this.curso = curso;
    }

    public String getEmailEducacional() {
        return emailEducacional;
    }

    public void setEmailEducacional(String emailEducacional) {
        this.emailEducacional = emailEducacional;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
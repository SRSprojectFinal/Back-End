package org.example.srs.Models;

public class GradeCurso {

    private String curso;
    private String professor;
    private String emailEducacional;

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

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor, String email) {
        this.professor = professor;
        this.emailEducacional = email;
    }
}

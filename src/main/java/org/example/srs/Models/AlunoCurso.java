package org.example.srs.Models;

public class AlunoCurso {
    private int id;
    private String nome;
    private String email;
    private String tp1;
    private String tp2;
    private String tp3;
    private String assesment;

    public AlunoCurso() {}

    public AlunoCurso(int id, String nome, String email, String tp1, String tp2, String tp3, String assesment) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tp1 = tp1;
        this.tp2 = tp2;
        this.tp3 = tp3;
        this.assesment = assesment;
    }

    public AlunoCurso(String nome, String email, String tp1, String tp2, String tp3, String assesment) {
        this.nome = nome;
        this.email = email;
        this.tp1 = tp1;
        this.tp2 = tp2;
        this.tp3 = tp3;
        this.assesment = assesment;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTp1() {
        return tp1;
    }

    public void setTp1(String tp1) {
        this.tp1 = tp1;
    }

    public String getTp2() {
        return tp2;
    }

    public void setTp2(String tp2) {
        this.tp2 = tp2;
    }

    public String getTp3() {
        return tp3;
    }

    public void setTp3(String tp3) {
        this.tp3 = tp3;
    }

    public String getAssesment() {
        return assesment;
    }

    public void setAssesment(String assesment) {
        this.assesment = assesment;
    }

    @Override
    public String toString() {
        return "AlunoCurso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tp1='" + tp1 + '\'' +
                ", tp2='" + tp2 + '\'' +
                ", tp3='" + tp3 + '\'' +
                ", assesment='" + assesment + '\'' +
                '}';
    }
} 
package org.example.srs.Service;

import org.example.srs.DataAccessObject.Cursos.*;
import org.example.srs.Models.AlunoCurso;

import java.util.List;

public class ExemploUsoListarAlunos {

    public static void main(String[] args) {
        // Exemplo de como usar o método listarTodos em todos os DAOs
        
        // Data Science
        DataDAO dataDAO = new DataDAO();
        List<AlunoCurso> alunosData = dataDAO.listarTodos();
        System.out.println("=== Alunos do curso Data Science ===");
        for (AlunoCurso aluno : alunosData) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosData.size());
        System.out.println();

        // Back End
        BackDAO backDAO = new BackDAO();
        List<AlunoCurso> alunosBack = backDAO.listarTodos();
        System.out.println("=== Alunos do curso Back End ===");
        for (AlunoCurso aluno : alunosBack) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosBack.size());
        System.out.println();

        // Front End
        FrontDAO frontDAO = new FrontDAO();
        List<AlunoCurso> alunosFront = frontDAO.listarTodos();
        System.out.println("=== Alunos do curso Front End ===");
        for (AlunoCurso aluno : alunosFront) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosFront.size());
        System.out.println();

        // Mobile
        MobileDAO mobileDAO = new MobileDAO();
        List<AlunoCurso> alunosMobile = mobileDAO.listarTodos();
        System.out.println("=== Alunos do curso Mobile ===");
        for (AlunoCurso aluno : alunosMobile) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosMobile.size());
        System.out.println();

        // Programming
        ProgrammingDAO programmingDAO = new ProgrammingDAO();
        List<AlunoCurso> alunosProgramming = programmingDAO.listarTodos();
        System.out.println("=== Alunos do curso Programming ===");
        for (AlunoCurso aluno : alunosProgramming) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosProgramming.size());
        System.out.println();

        // UI/UX
        UiDAO uiDAO = new UiDAO();
        List<AlunoCurso> alunosUI = uiDAO.listarTodos();
        System.out.println("=== Alunos do curso UI/UX ===");
        for (AlunoCurso aluno : alunosUI) {
            System.out.println("ID: " + aluno.getId() + 
                             " | Nome: " + aluno.getNome() + 
                             " | Email: " + aluno.getEmail() +
                             " | TP1: " + aluno.getTp1() +
                             " | TP2: " + aluno.getTp2() +
                             " | TP3: " + aluno.getTp3() +
                             " | Assessment: " + aluno.getAssesment());
        }
        System.out.println("Total de alunos: " + alunosUI.size());
    }
} 
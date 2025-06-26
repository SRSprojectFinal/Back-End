package org.example.srs.DataAccessObject;

import org.example.srs.Models.Historico;
import org.example.srs.Util.GerenciadorData;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {

    public HistoricoDAO() {
        try (Connection conn = GerenciadorData.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS Historicos (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "emailAluno TEXT NOT NULL, " +
                    "curso TEXT NOT NULL, " +
                    "situacao TEXT NOT NULL" +
                    ")");
            System.out.println("Tabela Historicos verificada/criada com sucesso.");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar HistoricoDAO: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Historico inserir(Historico historico) {
        if (historico.getEmailEducacional() == null || historico.getCurso() == null || historico.getSituacao() == null) {
            System.err.println("Erro ao inserir histórico: emailAluno, curso ou situacao nulo.");
            return null;
        }

        String sql = "INSERT INTO Historicos (emailAluno, curso, situacao) VALUES (?, ?, ?)";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, historico.getEmailEducacional());
            pstmt.setString(2, historico.getCurso());
            pstmt.setString(3, historico.getSituacao());
            pstmt.executeUpdate();
            System.out.println("Histórico inserido com sucesso!");
            return historico;
        } catch (SQLException e) {
            System.err.println("Erro ao inserir histórico: " + e.getMessage());
            return null;
        }
    }

    public List<Historico> buscarHistoricosPorEmailAluno(String emailAluno) {
        List<Historico> historicos = new ArrayList<>();
        String sql = "SELECT * FROM Historicos WHERE emailAluno = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emailAluno);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Historico historico = new Historico();
                    historico.setEmailEducacional(rs.getString("emailAluno"));
                    historico.setCurso(rs.getString("curso"));
                    try {
                        historico.setSituacao(rs.getString("situacao"));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Valor de situação inválido no banco para ID " + rs.getInt("id") + ": " + rs.getString("situacao"));
                    }
                    historicos.add(historico);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar históricos por email do aluno: " + e.getMessage());
        }

        return historicos;
    }

    public boolean atualizarSituacao(String emailAluno, String curso, String novaSituacao) {
        String sql = "UPDATE Historicos SET situacao = ? WHERE emailAluno = ? AND curso = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novaSituacao);
            pstmt.setString(2, emailAluno);
            pstmt.setString(3, curso);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar situação do histórico: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(String emailAluno, String curso) {
        String sql = "DELETE FROM Historicos WHERE emailAluno = ? AND curso = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, emailAluno);
            pstmt.setString(2, curso);
            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao deletar histórico: " + e.getMessage());
            return false;
        }
    }

    public List<Historico> listarTodos() {
        List<Historico> historicos = new ArrayList<>();
        String sql = "SELECT * FROM Historicos ORDER BY emailAluno";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Historico historico = new Historico();
                historico.setEmailEducacional(rs.getString("emailAluno"));
                historico.setCurso(rs.getString("curso"));
                try {
                    historico.setSituacao(rs.getString("situacao"));
                } catch (IllegalArgumentException e) {
                    System.err.println("Valor de situação inválido no banco para ID " + rs.getInt("id") + ": " + rs.getString("situacao"));
                }
                historicos.add(historico);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar todos os históricos: " + e.getMessage());
            e.printStackTrace();
        }

        return historicos;
    }
}

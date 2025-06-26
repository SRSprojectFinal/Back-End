package org.example.srs.DataAccessObject;

import org.example.srs.Models.GradeCurso;
import org.example.srs.Models.Usuario;
import org.example.srs.Util.GerenciadorData;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    public GradeDAO() {
        try (Connection conn = GerenciadorData.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS GradeCurso (" +
                    "Curso TEXT PRIMARY KEY, " +
                    "Professor TEXT, " +
                    "Email TEXT" +
                    ")");

            criarTabelaComCursosFixos();

        } catch (SQLException e) {
            System.err.println("Erro ao inicializar GradeDAO: " + e.getMessage());
        }
    }

    private void criarTabelaComCursosFixos() throws SQLException {
        String[] cursos = {
                "Back-End", "Front-End", "Data-Science",
                "Mobile", "Programming-Basis", "UI_UX"
        };

        try (Connection conn = GerenciadorData.conectar()) {
            for (String curso : cursos) {
                String sql = "INSERT OR IGNORE INTO GradeCurso (Curso, Professor, Email) VALUES (?, NULL, NULL)";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, curso);
                    pstmt.executeUpdate();
                }
            }
        }
    }

    public boolean atribuirProfessor(String curso, String professor, String email) {
        String sql = "UPDATE GradeCurso SET Professor = ?, Email = ? WHERE Curso = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, professor);
            pstmt.setString(2, email);
            pstmt.setString(3, curso);

            int linhas = pstmt.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atribuir professor: " + e.getMessage());
            return false;
        }
    }

    public boolean removerProfessor(String curso) {
        String sql = "UPDATE GradeCurso SET Professor = NULL, Email = NULL WHERE Curso = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, curso);
            int linhas = pstmt.executeUpdate();
            return linhas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao remover professor: " + e.getMessage());
            return false;
        }
    }

    public List<GradeCurso> listarGrade() {
        List<GradeCurso> lista = new ArrayList<>();
        String sql = "SELECT Curso, Professor, Email FROM GradeCurso";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                GradeCurso grade = new GradeCurso();
                grade.setCurso(rs.getString("Curso"));
                String professor = rs.getString("Professor");
                String email = rs.getString("Email");
                grade.setProfessor(professor, email);
                lista.add(grade);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar grade de cursos: " + e.getMessage());
        }
        return lista;
    }
}

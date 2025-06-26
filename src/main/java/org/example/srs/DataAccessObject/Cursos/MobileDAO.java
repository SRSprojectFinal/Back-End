package org.example.srs.DataAccessObject.Cursos;

import org.example.srs.Models.Usuario;
import org.example.srs.Models.AlunoCurso;
import org.example.srs.Util.GerenciadorData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MobileDAO {

    public MobileDAO() {
        try (Connection conn = GerenciadorData.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS Mobile (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "nome TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "tp1 TEXT NOT NULL, " +
                    "tp2 TEXT NOT NULL, " +
                    "tp3 TEXT NOT NULL, " +
                    "assesment TEXT NOT NULL" +
                    ")");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar UsuarioDAO: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void inserir(Usuario usuario, String tp1, String tp2, String tp3, String assesment) {
        String sql = "INSERT INTO Mobile (nome, email, tp1, tp2, tp3, assesment) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNomeCompleto());
            pstmt.setString(2, usuario.getEmailEducacional());
            pstmt.setString(3, tp1);
            pstmt.setString(4, tp2);
            pstmt.setString(5, tp3);
            pstmt.setString(6, assesment);
            pstmt.executeUpdate();
            System.out.println("Usuário inserido com sucesso no curso Mobile!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário no curso Mobile: " + e.getMessage());
        }
    }

    public boolean removerPorEmail(String email) {
        String sql = "DELETE FROM Mobile WHERE email = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Usuário com email " + email + " removido com sucesso do curso Mobile!");
                return true;
            } else {
                System.out.println("Nenhum usuário encontrado com o email " + email + " no curso Mobile.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover usuário do curso Mobile: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizarTp1(String email, String novoTp1) {
        String sql = "UPDATE Mobile SET tp1 = ? WHERE email = ?";
        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoTp1);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tp1 no Mobile: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizarTp2(String email, String novoTp2) {
        String sql = "UPDATE Mobile SET tp2 = ? WHERE email = ?";
        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoTp2);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tp2 no Mobile: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizarTp3(String email, String novoTp3) {
        String sql = "UPDATE Mobile SET tp3 = ? WHERE email = ?";
        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoTp3);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar tp3 no Mobile: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizarAt(String email, String novoAt) {
        String sql = "UPDATE Mobile SET assesment = ? WHERE email = ?";
        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, novoAt);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar TP no Mobile: " + e.getMessage());
            return false;
        }
    }

    public int contar() {
        String sql = "SELECT COUNT(*) FROM Mobile";
        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<AlunoCurso> listarTodos() {
        List<AlunoCurso> alunos = new ArrayList<>();
        String sql = "SELECT id, nome, email, tp1, tp2, tp3, assesment FROM Mobile ORDER BY nome";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                AlunoCurso aluno = new AlunoCurso(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("tp1"),
                    rs.getString("tp2"),
                    rs.getString("tp3"),
                    rs.getString("assesment")
                );
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos do curso Mobile: " + e.getMessage());
            e.printStackTrace();
        }

        return alunos;
    }

    public boolean removerTodos() {
        String sql = "DELETE FROM Mobile";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            int linhasAfetadas = pstmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Todos os usuários removidos com sucesso do curso Mobile!");
                return true;
            } else {
                System.out.println("Nenhum usuário encontrado no curso Mobile para remover.");
                return false;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao remover todos os usuários do curso Mobile: " + e.getMessage());
            return false;
        }
    }

}

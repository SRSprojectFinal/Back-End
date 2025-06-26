package org.example.srs.DataAccessObject;

import org.example.srs.Models.Usuario;
import org.example.srs.Util.GerenciadorData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public UsuarioDAO() {
        try (Connection conn = GerenciadorData.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS usuarios (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "identificador TEXT NOT NULL UNIQUE, " +
                    "nome TEXT NOT NULL, " +
                    "email TEXT NOT NULL UNIQUE, " +
                    "emailEducacional TEXT NOT NULL, " +
                    "senha TEXT NOT NULL, " +
                    "tipo TEXT NOT NULL" +
                    ")");
        } catch (SQLException e) {
            System.err.println("Erro ao inicializar UsuarioDAO: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Usuario inserir(Usuario usuario) {

        usuario.setIdentificador(gerarIdentificador(usuario));
        String sql = "INSERT INTO usuarios (identificador, nome, email, emailEducacional, senha, tipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getIdentificador());
            pstmt.setString(2, usuario.getNomeCompleto());
            pstmt.setString(3, usuario.getEmail());
            pstmt.setString(4, usuario.getEmailEducacional());
            pstmt.setString(5, usuario.getSenha());
            pstmt.setString(6, usuario.getTipoUsuario());
            pstmt.executeUpdate();
            return usuario;

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
            return null;
        }
    }

    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE emailEducacional = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdentificador(rs.getString("identificador"));
                usuario.setNomeCompleto(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEmailEducacional(rs.getString("emailEducacional"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo"));
                return usuario;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por email: " + e.getMessage());
        }

        return null;
    }

    public boolean verificarSeExiste(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdentificador(rs.getString("identificador"));
                usuario.setNomeCompleto(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEmailEducacional(rs.getString("emailEducacional"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo"));
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por email: " + e.getMessage());
        }

        return false;
    }

    public List<Usuario> listarTodos() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = GerenciadorData.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdentificador(rs.getString("identificador"));
                usuario.setNomeCompleto(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setEmailEducacional(rs.getString("emailEducacional"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipo"));
                lista.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }

        return lista;
    }

    public boolean atualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, emailEducacional = ?, senha = ?, tipo = ? WHERE email = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usuario.getNomeCompleto());
            pstmt.setString(2, usuario.getEmailEducacional());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, usuario.getTipoUsuario());
            pstmt.setString(5, usuario.getEmail());

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        }
    }

    public boolean deletarPorEmail(String email) {
        String sql = "DELETE FROM usuarios WHERE emailEducacional = ?";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            int linhasAlteradas = pstmt.executeUpdate();
            return linhasAlteradas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao deletar usuário por email: " + e.getMessage());
            return false;
        }
    }

    public int contar() {
        String sql = "SELECT COUNT(*) FROM usuarios";

        try (Connection conn = GerenciadorData.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String gerarIdentificador(Usuario usuario) {
        String prefixo = usuario.getTipoUsuario().substring(0, 3).toUpperCase();
        int aleatorio = (int)(Math.random() * 90000) + 10000;
        return prefixo + "-" + aleatorio;
    }
}

package org.example.srs.Controller;

import org.example.srs.DataAccessObject.UsuarioDAO;
import org.example.srs.Models.Usuario;
import org.example.srs.Util.Email;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:3000")
public class UsuarioController {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    @PostMapping
    public Map<String, Object> registrar(@RequestBody Usuario usuario) {
        Map<String, Object> response = new HashMap<>();

        if (usuarioDAO.verificarSeExiste(usuario.getEmail())) {
            response.put("success", false);
            response.put("message", "A user with this email address is already registered.");
            return response;
        }

        Usuario novoUsuario = usuarioDAO.inserir(usuario);

        if (novoUsuario != null) {
            if ("PROFESSOR".equals(usuario.getTipoUsuario())) {
                boolean emailEnviado = Email.sendWelcomeEmail(
                        usuario.getEmail(),
                        usuario.getEmailEducacional(),
                        usuario.getNomeCompleto()
                );

                if (!emailEnviado) {
                    System.err.println("Warning: Failed to send welcome email to professor: " + usuario.getEmail());
                }
            }

            if ("ALUNO".equals(usuario.getTipoUsuario())) {
                boolean emailEnviado = Email.sendWelcomeEmail(
                        usuario.getEmail(),
                        usuario.getEmailEducacional(),
                        usuario.getNomeCompleto()
                );

                if (!emailEnviado) {
                    System.err.println("Warning: Failed to send welcome email to professor: " + usuario.getEmail());
                }
            }

            response.put("success", true);
            response.put("usuario", novoUsuario);
        } else {
            response.put("success", false);
            response.put("message", "Erro ao cadastrar usuário.");
        }

        return response;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> dadosLogin) {
        String email = dadosLogin.get("email");
        String senha = dadosLogin.get("senha");
        Usuario usuario = usuarioDAO.buscarPorEmail(email);
        Map<String, Object> response = new HashMap<>();

        if (usuario != null && usuario.getSenha().equals(senha)) {
            response.put("success", true);
            response.put("usuario", usuario);
        } else {
            response.put("success", false);
            response.put("message", "E-mail ou senha inválidos.");
        }

        return response;
    }

    @GetMapping
    public Map<String, Object> listarTodos() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            List<Usuario> usuarios = usuarioDAO.listarTodos();
            response.put("success", true);
            response.put("usuarios", usuarios);
            response.put("total", usuarios.size());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao listar usuários: " + e.getMessage());
        }
        
        return response;
    }

    @DeleteMapping("/{email}")
    public Map<String, Object> deletarUsuario(@PathVariable String email) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            boolean deletado = usuarioDAO.deletarPorEmail(email);
            
            if (deletado) {
                response.put("success", true);
                response.put("message", "Usuário deletado com sucesso.");
            } else {
                response.put("success", false);
                response.put("message", "Usuário não encontrado ou erro ao deletar.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao deletar usuário: " + e.getMessage());
        }
        
        return response;
    }
}

package org.example.srs.Controller;

import org.example.srs.DataAccessObject.HistoricoDAO;
import org.example.srs.Models.Historico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/historico")
@CrossOrigin(origins = "http://localhost:3000")
public class HistoricoController {
    private final HistoricoDAO historicoDAO = new HistoricoDAO();

    @PostMapping("/adicionar")
    public ResponseEntity<Map<String, String>> adicionarHistorico(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Historico historico = new Historico();
            historico.setEmailEducacional(dados.get("emailEducacional"));
            historico.setCurso(dados.get("curso"));
            historico.setSituacao(dados.get("situacao"));
            
            Historico resultado = historicoDAO.inserir(historico);
            
            if (resultado != null) {
                response.put("mensagem", "Histórico adicionado com sucesso!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Erro ao adicionar histórico");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar histórico: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/buscar/{email}")
    public ResponseEntity<?> buscarHistoricosPorEmail(@PathVariable String email) {
        try {
            List<Historico> historicos = historicoDAO.buscarHistoricosPorEmailAluno(email);
            
            if (historicos.isEmpty()) {
                Map<String, String> response = new HashMap<>();
                response.put("mensagem", "Nenhum histórico encontrado para o email: " + email);
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
            
            return ResponseEntity.ok(historicos);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Erro ao buscar históricos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<Map<String, String>> deletarHistorico(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = historicoDAO.deletar(dados.get("emailAluno"), dados.get("curso"));
            
            if (sucesso) {
                response.put("mensagem", "Histórico deletado com sucesso!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Histórico não encontrado ou erro na exclusão");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao deletar histórico: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<?> listarTodosHistoricos() {
        try {
            List<Historico> historicos = historicoDAO.listarTodos();
            
            if (historicos.isEmpty()) {
                Map<String, String> response = new HashMap<>();
                response.put("mensagem", "Nenhum histórico encontrado");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
            
            return ResponseEntity.ok(historicos);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("mensagem", "Erro ao listar históricos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }
}

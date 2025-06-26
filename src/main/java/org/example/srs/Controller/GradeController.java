package org.example.srs.Controller;

import org.example.srs.DataAccessObject.GradeDAO;
import org.example.srs.Models.GradeCurso;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "http://localhost:3000")
public class GradeController {

    private final GradeDAO gradeDAO = new GradeDAO();

    @GetMapping
    public Map<String, Object> listarGrade() {
        Map<String, Object> response = new HashMap<>();
        
        try {
            List<GradeCurso> grade = gradeDAO.listarGrade();
            response.put("success", true);
            response.put("grade", grade);
            response.put("total", grade.size());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao listar grade de cursos: " + e.getMessage());
        }
        
        return response;
    }

    @PostMapping("/atribuir")
    public Map<String, Object> atribuirProfessor(@RequestBody Map<String, String> dados) {
        Map<String, Object> response = new HashMap<>();
        
        String curso = dados.get("curso");
        String professor = dados.get("professor");
        String email = dados.get("email");

        if (curso == null || professor == null || email == null) {
            response.put("success", false);
            response.put("message", "Curso, professor e email são obrigatórios.");
            return response;
        }

        try {
            boolean atribuido = gradeDAO.atribuirProfessor(curso, professor, email);
            
            if (atribuido) {
                response.put("success", true);
                response.put("message", "Professor atribuído ao curso com sucesso.");
            } else {
                response.put("success", false);
                response.put("message", "Erro ao atribuir professor ao curso.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao atribuir professor: " + e.getMessage());
        }
        
        return response;
    }

    @DeleteMapping("/remover/{curso}")
    public Map<String, Object> removerProfessor(@PathVariable String curso) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            boolean removido = gradeDAO.removerProfessor(curso);
            
            if (removido) {
                response.put("success", true);
                response.put("message", "Professor removido do curso com sucesso.");
            } else {
                response.put("success", false);
                response.put("message", "Erro ao remover professor do curso.");
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Erro ao remover professor: " + e.getMessage());
        }
        
        return response;
    }
}

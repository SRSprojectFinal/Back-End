package org.example.srs.Controller;

import org.example.srs.DataAccessObject.Cursos.*;
import org.example.srs.Models.AlunoCurso;
import org.example.srs.Models.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.srs.Util.Email;

@RestController
@RequestMapping("/cursos")
@CrossOrigin(origins = "http://localhost:3000")
public class CursosController {
    private final BackDAO backDAO = new BackDAO();
    private final FrontDAO frontDAO = new FrontDAO();
    private final MobileDAO mobileDAO = new MobileDAO();
    private final ProgrammingDAO programmingDAO = new ProgrammingDAO();
    private final UiDAO uiDAO = new UiDAO();
    private final DataDAO dataDAO = new DataDAO();


    @GetMapping("/backend/contar")
    public Map<String, Integer> contarBack() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", backDAO.contar());
        return response;
    }

    @GetMapping("/frontend/contar")
    public Map<String, Integer> contarFront() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", frontDAO.contar());
        return response;
    }

    @GetMapping("/mobile/contar")
    public Map<String, Integer> contarMobile() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", mobileDAO.contar());
        return response;
    }

    @GetMapping("/programming/contar")
    public Map<String, Integer> contarProgramming() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", programmingDAO.contar());
        return response;
    }

    @GetMapping("/uiux/contar")
    public Map<String, Integer> contarUi() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", uiDAO.contar());
        return response;
    }

    @GetMapping("/datascience/contar")
    public Map<String, Integer> contarData() {
        Map<String, Integer> response = new HashMap<>();
        response.put("quantidade", dataDAO.contar());
        return response;
    }


    @GetMapping("/backend/alunos")
    public List<AlunoCurso> listarAlunosBackend() {
        return backDAO.listarTodos();
    }

    @GetMapping("/frontend/alunos")
    public List<AlunoCurso> listarAlunosFrontend() {
        return frontDAO.listarTodos();
    }

    @GetMapping("/mobile/alunos")
    public List<AlunoCurso> listarAlunosMobile() {
        return mobileDAO.listarTodos();
    }

    @GetMapping("/programming/alunos")
    public List<AlunoCurso> listarAlunosProgramming() {
        return programmingDAO.listarTodos();
    }

    @GetMapping("/uiux/alunos")
    public List<AlunoCurso> listarAlunosUiUx() {
        return uiDAO.listarTodos();
    }

    @GetMapping("/datascience/alunos")
    public List<AlunoCurso> listarAlunosDataScience() {
        return dataDAO.listarTodos();
    }


    @PostMapping("/Back-End/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoBackend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            backDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso Backend!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/Front-End/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoFrontend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            frontDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso Frontend!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/Mobile/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoMobile(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            mobileDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso Mobile!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/Programming-Basis/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoProgramming(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            programmingDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso Programming!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/UI-UX-Desing/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoUiUx(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            uiDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso UI/UX!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/Data-Science/adicionar")
    public ResponseEntity<Map<String, String>> adicionarAlunoDataScience(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            Usuario usuario = new Usuario();
            usuario.setNomeCompleto(dados.get("nomeCompleto"));
            usuario.setEmailEducacional(dados.get("emailEducacional"));
            
            dataDAO.inserir(usuario, dados.get("tp1"), dados.get("tp2"), dados.get("tp3"), dados.get("assesment"));
            
            response.put("mensagem", "Aluno adicionado com sucesso ao curso Data Science!");
            response.put("status", "sucesso");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("mensagem", "Erro ao adicionar aluno: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/backend/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1Backend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = backDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso Backend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/backend/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2Backend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = backDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso Backend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/backend/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3Backend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = backDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso Backend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/backend/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentBackend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = backDAO.atualizarAt(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso Backend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/frontend/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1Frontend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = frontDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso Frontend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/frontend/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2Frontend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = frontDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso Frontend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/frontend/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3Frontend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = frontDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso Frontend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/frontend/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentFrontend(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = frontDAO.atualizarAt(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso Frontend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/mobile/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1Mobile(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = mobileDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso Mobile!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/mobile/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2Mobile(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = mobileDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso Mobile!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/mobile/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3Mobile(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = mobileDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso Mobile!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/mobile/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentMobile(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = mobileDAO.atualizarAt(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso Mobile!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/programming/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1Programming(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = programmingDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso Programming!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/programming/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2Programming(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = programmingDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso Programming!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/programming/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3Programming(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = programmingDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso Programming!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/programming/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentProgramming(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = programmingDAO.atualizarAT(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso Programming!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/uiux/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1UiUx(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = uiDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso UI/UX!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/uiux/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2UiUx(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = uiDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso UI/UX!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/uiux/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3UiUx(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = uiDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso UI/UX!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/uiux/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentUiUx(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = uiDAO.atualizarAt(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso UI/UX!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/datascience/atualizar/tp1")
    public ResponseEntity<Map<String, String>> atualizarTp1DataScience(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = dataDAO.atualizarTp1(dados.get("email"), dados.get("tp1"));
            
            if (sucesso) {
                response.put("mensagem", "TP1 atualizado com sucesso no curso Data Science!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP1: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/datascience/atualizar/tp2")
    public ResponseEntity<Map<String, String>> atualizarTp2DataScience(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = dataDAO.atualizarTp2(dados.get("email"), dados.get("tp2"));
            
            if (sucesso) {
                response.put("mensagem", "TP2 atualizado com sucesso no curso Data Science!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP2: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/datascience/atualizar/tp3")
    public ResponseEntity<Map<String, String>> atualizarTp3DataScience(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = dataDAO.atualizarTp3(dados.get("email"), dados.get("tp3"));
            
            if (sucesso) {
                response.put("mensagem", "TP3 atualizado com sucesso no curso Data Science!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar TP3: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/datascience/atualizar/assessment")
    public ResponseEntity<Map<String, String>> atualizarAssessmentDataScience(@RequestBody Map<String, String> dados) {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = dataDAO.atualizarAt(dados.get("email"), dados.get("assessment"));
            
            if (sucesso) {
                response.put("mensagem", "Assessment atualizado com sucesso no curso Data Science!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Aluno não encontrado ou erro na atualização");
                response.put("status", "erro");
                return ResponseEntity.badRequest().body(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao atualizar Assessment: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/backend/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosBackend() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = backDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso Backend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso Backend para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/frontend/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosFrontend() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = frontDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso Frontend!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso Frontend para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/mobile/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosMobile() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = mobileDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso Mobile!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso Mobile para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/programming/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosProgramming() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = programmingDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso Programming!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso Programming para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/uiux/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosUiUx() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = uiDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso UI/UX!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso UI/UX para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @DeleteMapping("/datascience/remover-todos")
    public ResponseEntity<Map<String, String>> removerTodosDataScience() {
        Map<String, String> response = new HashMap<>();
        
        try {
            boolean sucesso = dataDAO.removerTodos();
            
            if (sucesso) {
                response.put("mensagem", "Todos os alunos removidos com sucesso do curso Data Science!");
                response.put("status", "sucesso");
                return ResponseEntity.ok(response);
            } else {
                response.put("mensagem", "Nenhum aluno encontrado no curso Data Science para remover");
                response.put("status", "nao_encontrado");
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            response.put("mensagem", "Erro ao remover todos os alunos: " + e.getMessage());
            response.put("status", "erro");
            return ResponseEntity.badRequest().body(response);
        }
    }

}

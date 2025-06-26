# Sistema de Registro de Estudantes (SRS)

Este projeto contém um sistema completo de gerenciamento de estudantes com classes DAO para diferentes entidades.

## Estrutura do Projeto

### Models
- `Usuario` - Representa usuários do sistema (alunos e professores)
- `Historico` - Representa o histórico acadêmico dos alunos
- `GradeCurso` - Representa a grade de cursos
- `Situacao` - Enum para status de aprovação (APPROVED, FAILED)
- `TipoNota` - Enum para tipos de nota (D, DL, DML, ND)

### Data Access Objects (DAO)
- `UsuarioDAO` - Gerencia operações CRUD para usuários
- `HistoricoDAO` - Gerencia operações CRUD para históricos
- `BackDAO` - Gerencia alunos do curso BackEnd
- `FrontDAO` - Gerencia alunos do curso FrontEnd
- `DataDAO` - Gerencia alunos do curso DataScience
- `MobileDAO` - Gerencia alunos do curso Mobile
- `ProgrammingDAO` - Gerencia alunos do curso ProgrammingBasis
- `UiDAO` - Gerencia alunos do curso UI_UX

## Como Executar os Testes

### Pré-requisitos
- Java 21
- Maven

### Executando os Testes

1. **Compilar o projeto:**
   ```bash
   mvn clean compile
   ```

2. **Executar os testes das classes DAO:**
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.srs.SrsApplication"
   ```

   Ou alternativamente:
   ```bash
   java -cp target/classes org.example.srs.SrsApplication
   ```

### O que os Testes Fazem

O código de teste no `SrsApplication.java` executa:

#### Teste do UsuarioDAO:
1. Inserção de usuários (alunos e professores)
2. Busca de usuário por email
3. Verificação de existência de usuário
4. Listagem de todos os usuários
5. Contagem de usuários
6. Atualização de dados do usuário
7. Exclusão de usuário

#### Teste do HistoricoDAO:
1. Inserção de históricos acadêmicos
2. Busca de históricos por email do aluno
3. Busca de histórico específico por email e curso
4. Atualização de situação do histórico
5. Exclusão de histórico

#### Teste dos DAOs de Cursos:
1. Teste de cada DAO específico (Back, Front, Data, Mobile, Programming, UI/UX)
2. Inserção de alunos nos cursos
3. Remoção de alunos dos cursos

### Banco de Dados

O sistema utiliza SQLite como banco de dados. O arquivo `banco.db` será criado automaticamente na primeira execução.

### Saída Esperada

Ao executar os testes, você verá uma saída detalhada mostrando:
- ✓ Operações bem-sucedidas
- Mensagens de erro (se houver)
- Contadores e listagens
- Status de cada operação

### Exemplo de Saída:
```
=== TESTE DAS CLASSES DAO ===

--- TESTE USUARIO DAO ---
1. Testando inserção de usuários...
   ✓ Usuário 1 inserido com ID: ALU-12345
   ✓ Usuário 2 inserido com ID: ALU-67890
   ✓ Professor inserido com ID: PRO-11111

2. Testando busca por email...
   ✓ Usuário encontrado: João Silva

[... mais saídas ...]

=== TODOS OS TESTES CONCLUÍDOS ===
```

## Funcionalidades Testadas

- ✅ CRUD completo de usuários
- ✅ CRUD completo de históricos
- ✅ Inserção e remoção em cursos específicos
- ✅ Geração automática de identificadores
- ✅ Validações de dados
- ✅ Tratamento de erros
- ✅ Conexão com banco SQLite

## Observações

- O banco de dados SQLite será criado automaticamente
- Todos os testes são independentes e podem ser executados múltiplas vezes
- Os dados de teste são fictícios e servem apenas para demonstração
- O sistema suporta tanto alunos quanto professores 
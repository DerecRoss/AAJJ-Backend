# 🥋 AAJJ Web Service

Sistema web de gerenciamento de alunos e professores de Jiu-Jitsu. Desenvolvido com Java Spring Boot, autenticação baseada em usuário e role (ALUNO/PROFESSOR), persistência em banco de dados e frontend com HTML + JavaScript + Thymeleaf.

---

## 🚀 Funcionalidades

- ✅ Cadastro de usuários com dados completos
- ✅ Login com autenticação baseada em banco de dados
- ✅ Redirecionamento automático conforme o tipo de usuário:
  - `ALUNO` → Página de perfil
  - `PROFESSOR` → Página de turmas
- ✅ Logout funcional
- ✅ Exclusão de conta (usuário logado)
- ✅ Exclusão de alunos por professor
- ✅ Consulta de alunos por professor
- ✅ Atualização de dados do perfil
- ✅ Páginas protegidas por role com Spring Security
- ✅ Layout dinâmico que esconde botões de login/cadastro ao logar

---

## 🔐 Tecnologias utilizadas

- **Backend:**
  - Java 17+
  - Spring Boot 3.5+
  - Spring Security
  - Spring Data JPA
  - Lombok
  - Postgrees ( Via Docker )
  
- **Frontend:**
  - HTML5
  - JavaScript puro
  - Atualizações futuras

---

## 🧠 Roles e Autorização

O projeto utiliza o controle de acesso por **cargos (charge)**, definidos no cadastro:

- `ALUNO`: acessa `/profile`, atualiza/exclui seu próprio perfil
- `PROFESSOR`: acessa `/team`, consulta e remove alunos de sua turma

A segurança é aplicada:

- Via Spring Security (`SecurityConfig`)
- Com `@PreAuthorize` para métodos sensíveis (opcional)
- Por `SecurityFilterChain` + `@AuthenticationPrincipal`

---

📌 Melhorias futuras (próxima fase)

    Dashboard com métricas para professores

    Upload de fotos dos alunos

    Sistema de ranking ou graduação

    Integração com notificações por e-mail

## 🛠️ Como rodar localmente

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/aajj-backend.git
cd aajj-backend


Rode a aplicação com:

.mnvw spring-boot:run

acesse: http://localhost:8080/home


🧪 Exemplos de URLs

    GET /home: Página pública

    GET /login: Login

    POST /register: Cadastro de novo usuário

    GET /profile: Perfil do aluno logado

    GET /team: Página do professor

    GET /user/team?teacher=ANDERSON: Alunos do professor

    DELETE /user/api/profile: Excluir conta logada

    DELETE /user/api/admin/{id}: Professor exclui aluno

👨‍💻 Autor

Derec Ross

    GitHub: @DerecRoss


📝 Licença

Este projeto está sob a licença MIT.

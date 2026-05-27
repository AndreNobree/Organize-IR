# OrganizeIR

Sistema para organização, gerenciamento e simulação de declaração de imposto de renda desenvolvido com Java + Spring Boot.

---

# Objetivo

O OrganizeIR tem como objetivo facilitar:
- controle de rendimentos;
- controle de deduções;
- armazenamento de documentos;
- simulação de imposto;
- geração de relatórios;
- organização anual da declaração de IR.

---

# Tecnologias

## Backend
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven

---

# Documentação
- Swagger / OpenAPI

---

# Banco de Dados
- PostgreSQL
- Docker

---

# Funcionalidades

## Autenticação
- Registro de usuários
- Login com JWT
- Refresh Token
- Controle de permissões

---

## Declaração de IR
- Cadastro de anos fiscais
- Controle de status da declaração
- Simulação de imposto

---

## Rendimentos
- Cadastro de rendimentos
- Categorias de rendimento
- Controle por ano fiscal

---

## Deduções
- Cadastro de deduções
- Categorias dedutíveis
- Controle de despesas dedutíveis

---

## Documentos
- Upload de documentos
- Extração de informações
- Organização por categoria

---

## Relatórios
- Relatórios anuais
- Exportação futura em PDF
- Resumo financeiro

---

# Estrutura do Projeto

```text
OrganizeIR
├──
|   ├── organizeir/
|   │   ├── src/
|   │   │    ├── main/
|   │   │    │    ├── java/
|   │   │    │    │    └── com/example/organizeir/
|   │   │    │    │          ├── config/
|   │   │    │    │          ├── controller/
|   │   │    │    │          ├── dto/
|   │   │    │    │          ├── exception/
|   │   │    │    │          ├── model/
|   │   │    │    │          │     └── enums/
|   │   │    │    │          ├── repository/
|   │   │    │    │          ├── security/
|   │   │    │    │          ├── service/
|   │   │    │    │          └── utils/
|   │   │    │    │
|   │   │    │    └── resources/
|   │   │    │          ├── application.yml
|   │   │    │          ├── application-dev.yml
|   │   │    │          └── application-prod.yml
|   │   │    │
|   │   │    └── test/
|   │   │
|   └──pom.xml
|
├── docker-compose.yml
├──.env
├── README.md
```

---

# Configuração do Ambiente

## Pré-requisitos
- Java 17
- Maven
- Docker
- PostgreSQL

---

# Variáveis de Ambiente

## `.env`

```env
POSTGRES_DB=SEU-DB
POSTGRES_USER=SEU-USER
POSTGRES_PASSWORD=SUA-SENHA
```

---

# Docker

## Subir PostgreSQL

```bash
docker compose up -d
```

---

# Configuração do Spring Boot

## `application-dev.yml`

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/${POSTGRES_DB}
    username: ${POSTGRES_USER}
    password: ${POSTGRES_PASSWORD}

  jpa:
    hibernate:
      ddl-auto: update
```

---

# Executando o Projeto

## Rodar aplicação

```bash
mvn spring-boot:run
```

---

# Swagger

## Acessar documentação

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Perfis

## Desenvolvimento

```yaml
spring:
  profiles:
    active: dev
```

---

# Segurança

O projeto utiliza:
- Spring Security
- JWT Authentication
- Refresh Tokens
- Controle de Roles

---

# Roles

- ADMIN
- USER
- ACCOUNTANT

---

# Modelagem Principal

## Entidades
- User
- Role
- TaxYear
- Income
- Expense
- Deduction
- Document
- DocumentExtraction
- TaxSimulation
- Report
- Notification
- RefreshToken
- AuditLog

---

# Logs

Logs configurados com:
- SLF4J
- Logback

---

# Tratamento Global de Exceções

Implementado com:
- `@RestControllerAdvice`
- Exceptions customizadas
- Responses padronizadas

---

# Roadmap

## Backend
- [x] Modelagem inicial
- [x] Docker PostgreSQL
- [x] Swagger/OpenAPI
- [x] Exception Handler
- [x] Logging
- [ ] JWT Authentication
- [ ] Refresh Token
- [ ] Upload de arquivos
- [ ] Extração OCR
- [ ] Relatórios PDF
- [ ] Testes automatizados
- [ ] Flyway
- [ ] Dockerização completa

---

# Autor

André Nobre
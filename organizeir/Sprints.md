# IRFlow — Roadmap de Desenvolvimento

## Sprint 0 — Setup do Projeto

### Infraestrutura
- [x] Criar projeto Spring Boot
- [x] Configurar PostgreSQL
- [x] Configurar Docker
- [x] Configurar Swagger/OpenAPI
- [x] Configurar profiles (dev/prod)
- [x] Configurar logs
- [x] Configurar tratamento global de exceções

---

# Sprint 1 — Autenticação e Usuários

## Usuário
- [x] Criar entidade User
- [x] Criar entidade Role
- [x] Cadastro de usuário
- [x] Login JWT
- [x] Refresh Token
- [x] Logout

## Segurança
- [ ] Configurar Spring Security
- [ ] Implementar BCrypt
- [ ] Implementar autorização por roles
- [ ] Criar filtros JWT
- [ ] Proteger endpoints privados

## Validação
- [ ] Validar senha forte
- [ ] Validar e-mail único

---

# Sprint 2 — Cadastro Financeiro

## Rendimentos
- [x] Criar entidade Income
- [ ] CRUD de rendimentos
- [ ] Categorias de rendimento
- [ ] Validação anual

## Despesas
- [x] Criar entidade Expense
- [ ] CRUD de despesas
- [ ] Categorias de despesas

## Deduções
- [x] Criar entidade Deduction
- [ ] CRUD de deduções
- [ ] Validar limites de dedução

## API
- [ ] Paginação
- [ ] Ordenação
- [ ] Filtros
- [ ] Busca por período

---

# Sprint 3 — Upload de Documentos

## Upload
- [ ] Upload de PDF
- [ ] Upload de imagens
- [ ] Validação de arquivos
- [ ] Limite de tamanho

## Storage
- [ ] Configurar MinIO/S3
- [ ] Salvar metadata
- [ ] Versionamento de documentos

## Segurança
- [ ] Validar tipo MIME
- [ ] Criar antivírus mock

---

# Sprint 4 — OCR e Processamento Assíncrono

## OCR
- [ ] Configurar Tesseract OCR
- [ ] Extrair texto de PDFs
- [ ] Extrair texto de imagens

## Filas
- [ ] Configurar RabbitMQ/Kafka
- [ ] Criar fila de processamento
- [ ] Criar worker OCR

## Extração
- [ ] Extrair nome
- [ ] Extrair CPF/CNPJ
- [ ] Extrair valores
- [ ] Extrair datas

---

# Sprint 5 — Simulador de Imposto de Renda

## Regras
- [ ] Implementar cálculo simplificado
- [ ] Implementar cálculo completo
- [ ] Implementar cálculo de restituição
- [ ] Implementar cálculo de imposto devido

## Arquitetura
- [ ] Implementar Strategy Pattern
- [ ] Criar motor de cálculo tributário

## Simulações
- [ ] Comparar modelos de declaração
- [ ] Gerar resumo tributário

---

# Sprint 6 — Relatórios

## PDF
- [ ] Gerar relatório anual
- [ ] Gerar relatório de deduções
- [ ] Gerar resumo de rendimentos

## Excel
- [ ] Exportar dados financeiros
- [ ] Exportar relatórios fiscais

## Assíncrono
- [ ] Gerar relatórios em background

---

# Sprint 7 — Dashboard

## Métricas
- [ ] Total anual
- [ ] Gastos por categoria
- [ ] Rendimentos mensais
- [ ] Evolução financeira

## Performance
- [ ] Implementar cache Redis
- [ ] Criar queries otimizadas

---

# Sprint 8 — Alertas e Notificações

## Alertas
- [ ] Documento faltando
- [ ] Pendências fiscais
- [ ] Possíveis deduções
- [ ] Vencimentos importantes

## Notificações
- [ ] Configurar envio de e-mail
- [ ] Criar scheduler
- [ ] Criar fila de notificações

---

# Sprint 9 — Auditoria e Segurança Avançada

## Auditoria
- [ ] Registrar alterações
- [ ] Registrar acessos
- [ ] Histórico de mudanças

## Segurança
- [ ] Rate limiting
- [ ] Proteção brute force
- [ ] Logs sensíveis
- [ ] Controle granular de permissões

---

# Sprint 10 — Observabilidade

## Monitoramento
- [ ] Configurar Prometheus
- [ ] Configurar Grafana
- [ ] Configurar Micrometer

## Logs
- [ ] Centralizar logs
- [ ] Monitorar erros
- [ ] Monitorar performance

---

# Sprint 11 — Docker e Deploy

## Docker
- [ ] Criar Dockerfile
- [ ] Criar docker-compose
- [ ] Containerizar aplicação

## Deploy
- [ ] Deploy AWS
- [ ] Configurar ambiente produção
- [ ] Configurar variáveis seguras

---

# Sprint 12 — Funcionalidades Avançadas

## Open Finance
- [ ] Importar OFX
- [ ] Ler extratos bancários

## Inteligência Artificial
- [ ] Classificar documentos automaticamente
- [ ] Detectar categoria automaticamente

## Contabilidade
- [ ] Multiusuário contador/cliente
- [ ] Compartilhamento de documentos

## Futuro
- [ ] Declaração MEI
- [ ] Ganho de capital
- [ ] Criptoativos
- [ ] Chatbot tributário

---
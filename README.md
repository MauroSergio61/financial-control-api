# 💰 Financial Control API

API REST desenvolvida em Java com Spring Boot para controle financeiro pessoal.

Ela permite registrar receitas e despesas, filtrar por data ou tipo e gerar um resumo automático do seu saldo financeiro.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot 3.2.5
- Spring Data JPA
- PostgreSQL
- Swagger (OpenAPI)
- Maven
- Lombok

---

## 📌 Funcionalidades

- ✅ Criar transações (receitas e despesas)
- ✅ Listar todas as transações
- ✅ Filtrar por data
- ✅ Filtrar por tipo (INCOME ou EXPENSE)
- ✅ Gerar resumo financeiro (receitas, despesas e saldo)
- ✅ Documentação automática com Swagger

---

## 📂 Estrutura do projeto
com.mauro.financialcontrol
│
├── controller
├── service
├── repository
├── model
└── dto

Arquitetura em camadas seguindo boas práticas:
> Controller → Service → Repository → Database
---
## 📎 Principais endpoints
| Método | Endpoint                      | Descrição                           |
|------|-------------------------------|--------------------------------------|
| POST | /transactions                 | Criar nova transação                 |
| GET  | /transactions                 | Listar todas as transações           |
| GET  | /transactions/type/{type}     | Filtrar por tipo (INCOME/EXPENSE)   |
| GET  | /transactions/filter           | Filtrar por data (start / end)       |
| GET  | /transactions/summary          | Gerar resumo financeiro              |
---
## 📄 Documentação com Swagger
Após iniciar o projeto, acesse:
http://localhost:8080/swagger-ui.html
Interface interativa para testar todos os endpoints.
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/6c493d6c-7c1c-4f61-b188-c7928723e8d4" />

<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/692c7cb6-7d58-4e2a-8390-33721dda6994" />

---

## 🛠 Environment Setup

Este projeto utiliza PostgreSQL.




1️⃣ Crie um banco PostgreSQL chamado financial_control.
Crie um arquivo .env ou application.properties local com:
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
Rode a aplicação.

2️⃣ Configure suas variáveis de ambiente:
Windows (PowerShell)
setx DB_USERNAME "seu_usuario"
setx DB_PASSWORD "sua_senha"

**Linux / Mac**
export DB_USERNAME=seu_usuario
export DB_PASSWORD=sua_senha

Ou crie um arquivo application.properties local (não versionado):
spring.datasource.url=jdbc:postgresql://localhost:5432/financial_control
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

3️⃣ Rode a aplicação pelo IntelliJ ou via terminal:
./mvnw spring-boot:run
Depois acesse:http://localhost:8080/swagger-ui.html

Exemplos de uso (Postman / Swagger)
Criar transação:
{
  "description": "Salário",
  "value": 2500,
  "type": "INCOME",
  "date": "2025-01-10"
}
Filtrar por data: /transactions/filter?start=2025-01-01&end=2025-01-31
Gerar resumo:/transactions/summary
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/4e975cdf-e8db-4aae-bc96-1ff839e5d6ff" />

🎯 Objetivo deste projeto

Este projeto foi desenvolvido com foco em aprendizado prático de Java e Spring Boot, aplicando conceitos de:

Arquitetura em camadas
Boas práticas de desenvolvimento
Integração com banco de dados
Criação de APIs REST
Organização e padrão profissional de código

👨‍💻 Autor
Mauro Pereira
Desenvolvedor Back-end em formação (Java + Spring Boot)

📎 LinkedIn:
https://www.linkedin.com/in/mauro-sergio1861

📂 GitHub:
https://github.com/MauroSergio61



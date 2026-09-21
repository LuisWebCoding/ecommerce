# 🛒 E-Commerce API

API RESTful desenvolvida em Java com Spring Boot para gerenciamento do fluxo de um e-commerce, aplicando arquitetura em camadas, validações consistentes e tratamento de integridade relacional.

---

## 🚀 Tecnologias Utilizadas

* **Java 17 / 21**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência e ORM com Hibernate)
* **Spring Validation** (Validação declarativa de entrada)
* **H2 Database** (Banco relacional em memória para desenvolvimento)
* **Lombok** (Redução de código boilerplate)
* **Maven** (Gerenciamento de dependências e build)

---

## 🏛️ Arquitetura do Projeto

O projeto adota uma arquitetura em camadas desacopladas:

```text
com.ecommerce.api
 ├── controller     -> Recepção de requisições HTTP e entrega de respostas REST
 ├── dto            -> Contratos de entrada (Request) e saída (Response)
 ├── entity         -> Mapeamento relacional das tabelas (JPA / Hibernate)
 ├── exception      -> Exceções de negócio e customizadas da aplicação
 ├── repository     -> Interfaces de comunicação com o banco (Spring Data JPA)
 └── service        -> Regras de negócio, transações e validações lógicas

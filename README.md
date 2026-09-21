# 🛒 E-Commerce API

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de um fluxo simplificado de e-commerce, aplicando arquitetura em camadas e boas práticas de desenvolvimento back-end.

---

## 🚀 Tecnologias Utilizadas

* **Java 17 / 21**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência e ORM com Hibernate)
* **Spring Validation** (Validação de contratos de entrada)
* **H2 Database** (Banco em memória para desenvolvimento)
* **Lombok** (Produtividade e redução de código boilerplate)
* **Maven** (Gerenciador de dependências e build)

---

## 🏛️ Arquitetura do Projeto

O projeto segue a divisão em camadas com separação clara de responsabilidades:

* `controller`: Endpoints HTTP REST e retorno de status codes padronizados.
* `dto`: Transferência de dados (Request/Response) isolando a base de dados do cliente externo.
* `service`: Regras de negócio e transações de banco de dados.
* `repository`: Interfaces de comunicação com o banco via Spring Data JPA.
* `entity`: Modelagem relacional das tabelas.

---

## 📌 Endpoints Disponíveis

### Categorias (`/api/categories`)

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/api/categories` | Lista todas as categorias cadastradas |
| `GET` | `/api/categories/{id}` | Busca uma categoria por ID |
| `POST` | `/api/categories` | Cadastra uma nova categoria |
| `DELETE` | `/api/categories/{id}` | Remove uma categoria existente |

#### Exemplo de requisição (POST):
```json
{
  "name": "Eletrônicos"
}

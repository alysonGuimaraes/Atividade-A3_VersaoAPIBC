# 💰 API - Valores a Receber

Esta API faz parte de um projeto de avaliação da UC de sistemas distribuídos e mobile. Seu objetivo é 
retornar os valores a receber de um proponente, consultando pelo CPF e data de nascimento, imitando o 
funcionamento da API de valores a Receber do Banco Central.

---

## 🔧 Tecnologias Utilizadas

- Java 24
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (em memória)
- Maven
- Postman (para testes)

---

## 📁 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── com.valoresareceber
│   │       ├── controllers
│   │       ├── dto
│   │       ├── models
│   │       ├── repository
│   │       ├── exception
│   │       ├── utils
│   │       ├── validators
│   │       └── ValoresAReceberApplication.java
│   └── resources
│       ├── application.properties
│       └── data.sql
```

- **model/**: contém as entidades `Proponente`, `ValoresReceber`, `LogConsulta`.
- **repository/**: interfaces JPA para acesso ao banco de dados.
- **dto/**: objetos para retorno de dados (ex: `ValorDTO`, `ValoresReceberRequestDTO`).
- **controller/**: classes com os endpoints REST.
- **exception/**: classes para retorno não generico em caso de erro.
- **utils/**: classes utilitárias para realizar validações de campos.
- **validators/**: classes para validações de valores.

---

## 🚀 Como Executar

### Pré-requisitos

- Java 24 instalado
- Maven 3.8+ instalado

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seuusuario/api-valores-a-receber.git
   ```

2. Importe o projeto na sua IDE (IntelliJ, Eclipse, VS Code etc.).

3. Execute a classe `ValoresAReceberApplication.java` como aplicação Spring Boot.

---

## 📌 Endpoints Disponíveis

### 🔍 Consultar valores por CPF e data de nascimento

```
GET /valores-a-receber/valores?cpf={cpf}&dta_nasc={dd-MM-aaaa}
```

#### ✅ Exemplo:
```
/valores-a-receber/valores?cpf=12345678900&dta_nasc=20-05-1990
```

#### 🔄 Respostas:
- `200 OK`: Retorna valores encontrados com dados do proponente.
```json
{
    "CPF proponente": "29891443078",
    "valores_a_receber": [
        {
            "nomeInstituicao": "Banco XYZ",
            "cnpj": "71710084000103",
            "valor": 1500.75,
            "tipoValor": "Antecipação",
            "observacao": "Recebido parcialmente",
            "dtaReferencia": "2024-01-01"
        }
    ],
    "Nome proponente": "João Silva",
    "Possui_valores_receber": true
}
```
- `404 NOT FOUND`: Proponente não encontrado.
````json
{
    "CPF proponente": "08800423973",
    "mensagem": "Proponente não encontrado, verifique se o CPF foi digitado corretamente"
}
````
- `200 OK`: Proponente sem valores a receber.
````json
{
    "CPF proponente": "60946323038",
    "valores_a_receber": [],
    "Nome proponente": "Joaquim Borges",
    "Possui_valores_receber": false
}
````

---

### ➕ Cadastrar proponente

```
POST /valores-a-receber/proponente
```

```json
{
  "nome": "Maria Silva",
  "cpf": "29891443078",
  "dtaNascimento": "1990-05-20"
}
```

---

### ➕ Cadastrar valor a receber

```
POST /valores
```

```json
{
  "cpf": "29891443078",
  "nomeInstituicao": "Banco ABC",
  "cnpj": "12345678000199",
  "valor": 1500.75,
  "tipoValor": "Saldo",
  "observacao": "Valor de conta inativa",
  "dtaReferencia": "2024-12-01"
}
```

---

## 📝 Logs de Consulta

Cada consulta gera um log salvo na tabela `log_consulta` com os seguintes dados:

- `id`: UUID
- `dta_consulta`: data e hora da consulta
- `cpf_consultado`: CPF enviado na requisição
- `prop_no_banco`: indica se o proponente existia no banco
- `possui_valores`: indica se o proponente tinha valores a receber

---

## 🧪 Testes

Use o Postman ou Insomnia para testar os endpoints REST.

---

## 👨‍💻 Autor

Desenvolvido por **Alyson Guimarães** — entre em contato para dúvidas ou sugestões!

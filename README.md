# 📚 LiterAlura

Projeto desenvolvido como parte do **desafio LiterAlura** do programa **Oracle Next Education (ONE) em parceria com a Alura**.

O objetivo do projeto é praticar o consumo de uma API externa e a persistência de dados em um banco de dados relacional utilizando **Java e Spring Boot**.

---

## 🎯 Objetivo do Desafio

- Consumir dados da **API Gutendex**
- Buscar livros pelo título
- Armazenar livros e autores em um banco de dados **PostgreSQL**
- Realizar consultas utilizando apenas os dados persistidos
- Interagir com o usuário por meio de um **menu no terminal**

---

## 🛠️ Tecnologias Utilizadas

- Java  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- API Gutendex  

---

## 📌 Funcionalidades Implementadas

O sistema apresenta um menu com as seguintes opções:

1. **Buscar livro pelo título**  
   - Consulta a API Gutendex  
   - Salva o livro e o autor no banco de dados  

2. **Listar livros registrados**  
   - Exibe todos os livros cadastrados  

3. **Listar autores**  
   - Exibe todos os autores cadastrados  

4. **Listar autores vivos em determinado ano**  
   - Retorna autores que estavam vivos no ano informado  

5. **Listar livros em determinado idioma**  
   - Permite filtrar livros por idioma (PT, EN, FR, ES)  

---

## 🗄️ Banco de Dados

- Banco de dados: **PostgreSQL**
- As tabelas são criadas automaticamente pelo **Spring Data JPA**
- As configurações de conexão estão no arquivo `application.properties`

---

## ▶️ Como Executar o Projeto

1. Criar um banco de dados no PostgreSQL com o nome `literalura`
2. Configurar usuário e senha no arquivo `application.properties`
3. Executar a aplicação pela classe `LiteraluraApplication`
4. Utilizar o menu exibido no terminal para interagir com o sistema

---

## 🌐 API Utilizada

- **Gutendex API**  
  API pública que disponibiliza dados de mais de 70 mil livros do Projeto Gutenberg.

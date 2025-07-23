# 📚 LiterAlura: Catálogo de Livros com Spring Boot

<img src="https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white">
<img src="https://img.shields.io/badge/Alura-13294B?style=for-the-badge&logo=data:image/svg+xml;base64,...">

Este projeto foi desenvolvido como parte do desafio **PRATICANDO SPRING BOOT – CHALLENGE LITERALURA**, com o objetivo de construir um catálogo de livros interativo via terminal, utilizando Java 17, Spring Boot, PostgreSQL e a API Gutendex.

---

## 🧠 Desafio

O desafio propõe a criação de uma aplicação Java com Spring Boot que permita ao usuário interagir via terminal para buscar, listar e filtrar livros e autores. Os dados são obtidos da API Gutendex e armazenados localmente em um banco relacional, promovendo o aprendizado prático em:

- Consumo da [API Gutendex](https://gutendex.com/) para buscar informações de livros.
- Persistência de dados com Spring Data JPA.
- Criação de entidades e relacionamento entre tabelas.
- Interação com o usuário por meio de menus e opções no console.
- Implementar filtros e consultas personalizadas sobre os dados persistidos.

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **PostgreSQL**
- **API Gutendex (https://gutendex.com/)**
- **Jackson (para parse de JSON)**
- **Maven**

---

## 🌐 Sobre a API Gutendex

📚 **Gutendex API** é uma interface web que facilita o acesso ao vasto acervo de livros gratuitos do [Project Gutenberg](https://gutendex.com/) — uma biblioteca digital com milhares de obras de domínio público.

### ✨ O que ela faz
- **Serve metadados de livros** como título, autor, idioma, número de downloads, formatos disponíveis, entre outros.
- **Permite buscas avançadas** por autor, idioma, ano de nascimento, palavras-chave, temas e muito mais.
- **Retorna dados em JSON**, ideal para integrar com aplicações web, bots, ou análises automatizadas.

### 🔍 Exemplos de uso
- Listar livros populares:  
  `GET https://gutendex.com/books`
- Buscar por autor ou título:  
  `GET https://gutendex.com/books?search=shakespeare`
- Filtrar por idioma:  
  `GET https://gutendex.com/books?languages=pt`

### 🛠️ Tecnologias
- Construída com **Django**
- Utiliza arquivos XML publicados pelo Project Gutenberg e os transforma em uma API REST simples

Se quiser, posso te mostrar como fazer uma requisição usando Python ou integrar com seu projeto Spring. Quer ver um exemplo prático?

### 🔍 Exemplo de requisição:

![](assets/json_api.png)

---

## ✅ Funcionalidades da Aplicação

1. **Buscar Livro pelo Título**  
   O usuário pode inserir o nome de um livro para buscá-lo na API Gutendex. Caso encontrado, o livro será salvo no banco de dados.

2. **Listar Livros Registrados**  
   Exibe todos os livros salvos no banco de dados, com título, idioma e autor.

3. **Listar Autores**  
   Mostra todos os autores registrados, incluindo os livros associados a cada um.

4. **Listar Autores Vivos em um Determinado Ano**  
   Permite buscar autores que estavam vivos em um ano informado pelo usuário.

5. **Listar Livros por Idioma**  
   Exibe os livros filtrando por idioma (pt, en, es, fr).

---

## 🚀 Como a Aplicação Funciona (Passo a Passo)

### 1. Inicialização
Ao rodar a aplicação, um menu interativo é exibido no terminal com as opções disponíveis:

![](assets/menu.png)

Buscar Livro pelo Título: 
O usuário insere o opção desejada, neste caso, opção 1. 
Em seguida digitar o nome de um livro, a aplicação faz uma requisição para a API Gutendex, caso o livro seja encontrado, seus dados são salvos no banco de dados. Se o livro não for encontrado, será exibido uma mensagem "Livro não encontrado. Tente outro título.", mas se o livro já estiver salvo no banco de dados, a seguinte mensagem será mostrada "Livro já consta no banco de dados."

![](assets/resultado_opcao_1.png)

Listar Livros Registrados: 
Consulta o banco de dados e exibe todos os livros cadastrados com suas informações principais.

![](assets/resultado_opcao_2.png)

Listar Autores Registrados: 
Mostra todos os autores únicos e exibe os livros associados a cada autor.

![](assets/resultado_opcao_3.png)

Buscar Autores Vivos em um Ano: 
O usuário informa um ano (ex: 1839). A aplicação retorna todos os autores que estavam vivos nesse ano.

![](assets/resultado_opcao_4.png)

Listar Livros por Idioma: 
O usuário escolhe um idioma (ex: pt). A aplicação filtra os livros registrados nesse idioma. 

![](assets/resultado_opcao_5.png)

Sair da aplicação: 
Mostra um "Até logo..." ao usuário, assim encerrando a aplicação.

![](assets/resultado_opcao_0.png)

---

## 💡 Melhorias futuras
- Top 10 livros mais baixados.

- Buscar autor pelo nome.

- Consultas com ordenações e paginações.

- Estatísticas de idiomas, autores mais populares, etc.

---

## 🏁 Conclusão
Este projeto oferece uma experiência prática completa com Java, Spring Boot, consumo de APIs REST, persistência com JPA e interação com banco de dados PostgreSQL. Ideal para quem busca consolidar conhecimentos em desenvolvimento backend moderno.

Sinta-se à vontade para contribuir, reportar problemas ou sugerir melhorias!

---

## 📂 Como Executar
1. Clone o repositório do projeto:
   ```bash
   git clone https://github.com/NayaraCalixto/LiterAlura

## 👨‍🏫 Instrutores
- Jacqueline Oliveira
- Iasmin Araújo

---

## 🚀 Projeto do Curso Java One
Este projeto faz parte do desafio proposto no curso <strong>Java One</strong>, com o objetivo de consolidar os aprendizados iniciais em Java através da criação de um sistema prático e funcional.


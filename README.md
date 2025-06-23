# Sistema de Gerenciamento de Tarefas

Este é um sistema em Java para gerenciamento de tarefas e pessoas, utilizando JDBC com MySQL, interface gráfica via `JOptionPane` e arquitetura MVC. O sistema permite criar, atualizar, visualizar e excluir tarefas e pessoas de forma simples e eficiente.

## 💡 Funcionalidades

- **Pessoa**
  - Cadastro de nova pessoa
  - Listagem de todas as pessoas
  - Atualização de nome
  - Exclusão por ID

- **Tarefa**
  - Cadastro de nova tarefa com data de entrega e pessoa responsável
  - Listagem de todas as tarefas
  - Atualização de:
    - Nome da tarefa
    - Data de entrega
    - Pessoa responsável
  - Exclusão de tarefa


## 🏗️ Arquitetura

O projeto segue o padrão **MVC (Model-View-Controller)**:

- **Model**:
  - `Pessoa.java`
  - `Tarefa.java`

- **DAO (Data Access Object)**:
  - `PessoaDAO.java`
  - `TarefaDAO.java`

- **Controller**:
  - `PessoaController.java`
  - `TarefaController.java`

- **View**:
  - Interface gráfica via `JOptionPane`
  - Menus e submenus dinâmicos para operações CRUD

## ⚙️ Tecnologias Utilizadas
 - Java 17+

 - JDBC

 - MySQL

 - JOptionPane (Swing)

 - Eclipse IDE

 - Git + GitHub

## 🚀 Como Executar

 - Clone este repositório:

bash
Copiar
Editar
git clone https://github.com/Andre-Benchetrit/Agenda-Java-MySql.git
 - Importe o projeto no Eclipse.

 - Crie o banco de dados utilizando o script no /sql.

 - Ajuste a conexão em Conexao.java com seu usuário e senha MySQL.

 - Execute a classe principal para começar a utilizar o sistema.

## 🙋 Sobre
 - **Este projeto foi desenvolvido com foco no aprendizado de**:

 - Integração Java e banco de dados

 - Estrutura MVC

 - Manipulação de datas (LocalDate)

 - Boas práticas de modularização

## 📁 GitHub do projeto: https://github.com/Andre-Benchetrit/Agenda-Java-MySql

## 📍 Caso queira trocar uma idéia, fazer sugestões ou assuntos profissionais (contratação de serviços), essas são minhas redes de contato:

 - Linkedln: www.linkedin.com/in/andre-benchetrit
 - Email: andrebenchetrit@hotmail.com

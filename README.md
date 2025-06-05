# 📒 Agenda Java + MySQL

Projeto simples de agenda desenvolvido em Java com persistência de dados em banco MySQL. Criado com foco em aprendizado de programação orientada a objetos, manipulação de banco de dados e estrutura MVC.

![image](https://github.com/user-attachments/assets/a2bdf304-e19c-442e-b102-6b3a9b62f998)


## 📌 Funcionalidades Atuais

- Cadastro de pessoas
- Cadastro de tarefas com data de entrega e encarregado
- Busca por tarefas usando:
  - Nome da tarefa
  - Data de entrega
  - Nome do encarregado
- Listagem geral de tarefas e pessoas
- Exclusão de tarefas
- Conexão com banco de dados via JDBC

  ![image](https://github.com/user-attachments/assets/e5d5dbcc-5e73-43a5-ba24-3a133a23d06f)


## 📂 Estrutura do Projeto

- **model/** → classes `Pessoa` e `Tarefa`
- **dao/** → acesso ao banco de dados (`PessoaDAO`, `TarefaDAO`, `Conexao`)
- **controller/** → regras de negócio (`PessoaController`, `TarefaController`)
- **view/** → interface de linha de comando (`PessoaView`, `TarefaView`, `Main`)

## ⚙️ Tecnologias Utilizadas

- Java
- MySQL
- JDBC
- Eclipse IDE

## 🚀 Como Rodar o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/Agenda-Java-MySql.git

2. Importe no Eclipse como projeto Java existente.

3. Use o diretório /sql para fazer a criação do banco dados.

4. Atualize as credenciais no arquivo Conexao.java.

5. Rode a classe Main.java.

## 🛠️ Melhorias Futuras
 - Validação de dados mais robusta
 - Confirmação ao excluir registros (DROP)
 - Interface gráfica com Swing ou JavaFX
 - Atualização (UPDATE) de tarefas e pessoas
 - Integração com APIs externas (ex: feriados, clima)
 - Cadastro de usuários (login)

## 🙋‍♂️ Objetivo
Este projeto faz parte do meu processo de aprendizado em Java. A ideia é evoluir ele com novos recursos, e ao mesmo tempo registrar minha evolução como desenvolvedor.

## 📫 Contato
Estou aberto para comissões e contratação. Se quiser trocar ideia, feedback ou sugestão:

[LinkedIn](https://www.linkedin.com/in/andr%C3%A9-benchetrit-8aa9ba183)

andrebenchetrit@hotmail.com

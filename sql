-- Criar o banco
DROP DATABASE IF EXISTS agenda;
CREATE DATABASE agenda;
USE agenda;

-- Tabela de Pessoa
CREATE TABLE pessoa (
    idPessoa INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(45) NOT NULL,
    Endereco VARCHAR(45),
    Cidade VARCHAR(45),
    CEP VARCHAR(45)
);

-- Tabela de Tarefa
CREATE TABLE tarefa (
    idTarefa INT AUTO_INCREMENT PRIMARY KEY,
    nomeTarefa VARCHAR(45) NOT NULL,
    dataEntrega DATE,
    Pessoa_idPessoa INT,
    FOREIGN KEY (Pessoa_idPessoa) REFERENCES pessoa(idPessoa)
);

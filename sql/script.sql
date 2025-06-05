-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS agenda;
USE agenda;

-- Tabela de Pessoa
CREATE TABLE IF NOT EXISTS pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Tabela de Tarefa
CREATE TABLE IF NOT EXISTS tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dataEntrega DATE NOT NULL,
    idPessoa INT,
    FOREIGN KEY (idPessoa) REFERENCES pessoa(id)
);
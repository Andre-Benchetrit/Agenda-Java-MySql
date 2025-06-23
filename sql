CREATE TABLE IF NOT EXISTS Pessoa (
    idPessoa INT NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(45) NOT NULL,
    Endereco VARCHAR(45),
    Cidade VARCHAR(45),
    CEP VARCHAR(45),
    PRIMARY KEY (idPessoa)
);

CREATE TABLE Tarefa (
    idTarefa INT NOT NULL AUTO_INCREMENT,
    nomeTarefa VARCHAR(45) NOT NULL,
    dataEntrega DATE,
    Pessoa_idPessoa INT NOT NULL,
    PRIMARY KEY (idTarefa),
    KEY fk_Tarefa_Pessoa_idx (Pessoa_idPessoa),
    CONSTRAINT fk_Tarefa_Pessoa
        FOREIGN KEY (Pessoa_idPessoa)
        REFERENCES Pessoa (idPessoa)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
);

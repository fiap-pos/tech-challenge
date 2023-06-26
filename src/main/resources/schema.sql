CREATE TABLE IF NOT EXISTS produto (
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(30) NOT NULL,
    categoria enum ('LANCHE', 'ACOMPANHAMENTO', 'BEBIDA', 'SOBREMESA') NOT NULL,
    preco double NOT NULL,
    descricao text NOT NULL,
    imagem LONGBLOB,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS cliente (
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(255) NOT NULL,
    cpf varchar(14) NOT NULL UNIQUE,
    email varchar(255) NOT NULL UNIQUE,
    primary key (id)
);


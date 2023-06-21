create database if not exists lanchonete_db;
use lanchonete_db;

CREATE TABLE produto (
    id int not null,
    nome varchar(30) not null,
    categoria enum ('Lanche', 'Acompanhamento', 'Bebida', 'Sobremesa') NOT NULL,
    preco double not null,
    descricao text not null,
    imagem blob,
    primary key (id)
);

INSERT INTO produto (id, nome, categoria, preco, descricao) value (1, 'Hamburguer', 'Lanche', 10.99, 'Hamburguer teste');

CREATE TABLE IF NOT EXISTS produto (
    id int NOT NULL AUTO_INCREMENT,
    nome varchar(30) NOT NULL,
    categoria enum ('Lanche', 'Acompanhamento', 'Bebida', 'Sobremesa') NOT NULL,
    preco double NOT NULL,
    descricao text NOT NULL,
    imagem blob,
	primary key (id)
);

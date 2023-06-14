CREATE TABLE IF NOT EXISTS produto (
    id int not null,
    nome varchar(30) not null,
    categoria enum ('Lanche', 'Acompanhamento', 'Bebida', 'Sobremesa') NOT NULL,
    preco double not null,
    descricao text not null,
    imagem blob,
	primary key (id)
);

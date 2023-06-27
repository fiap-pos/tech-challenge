CREATE TABLE IF NOT EXISTS produto (
    id bigint NOT NULL AUTO_INCREMENT,
    nome varchar(30) NOT NULL,
    categoria enum ('LANCHE', 'ACOMPANHAMENTO', 'BEBIDA', 'SOBREMESA') NOT NULL,
    preco double NOT NULL,
    descricao text NOT NULL,
    imagem LONGBLOB,
	primary key (id)
);

CREATE TABLE IF NOT EXISTS pedido (
    id int NOT NULL AUTO_INCREMENT,
    status enum ('PENDENTE_DE_PAGAMENTO', 'PAGO','RECEBIDO','EM_PREPARACAO','PRONTO','FINALIZADO') NOT NULL,
    clienteid int NOT NULL,
    produtoid int NOT NULL,
    quantidade int NOT NULL,
    FOREIGN KEY (produtoid) REFERENCES produto(id),
	primary key (id)
);

CREATE TABLE IF NOT EXISTS cobranca (
    id bigint NOT NULL AUTO_INCREMENT,
    id_pedido bigint  NOT NULL,
    status enum ('PENDENTE', 'PAGO', 'CANCELADO')  NOT NULL,
    valor double NOT NULL,
    qr_code text NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    primary key (id),
    index(status)
);
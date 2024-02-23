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
  id bigint AUTO_INCREMENT,
  status enum ('PENDENTE_DE_PAGAMENTO','PAGO','RECEBIDO','EM_PREPARACAO','PRONTO','FINALIZADO','CANCELADO'),
  data timestamp NOT NULL,
  cliente_id VARCHAR(255) DEFAULT NULL,
  valor_total double,
  primary key (id),
  index(cliente_id)
);

CREATE TABLE IF NOT EXISTS item_pedido (
  id bigint AUTO_INCREMENT,
  pedido_id bigint NOT NULL,
  produto_id bigint NOT NULL,
  quantidade int NOT NULL,
  valor_unitario double NOT NULL,
  primary key (id),
  FOREIGN KEY (pedido_id) REFERENCES pedido (id),
  FOREIGN KEY (produto_id) REFERENCES produto (id)
);

CREATE TABLE IF NOT EXISTS cobranca (
    id bigint NOT NULL AUTO_INCREMENT,
    pedido_id bigint  NOT NULL,
    status enum ('PENDENTE', 'PAGO', 'CANCELADO')  NOT NULL,
    valor double NOT NULL,
    qr_code text NOT NULL,
    created_at timestamp NOT NULL,
    updated_at timestamp NOT NULL,
    primary key (id),
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    index(status)
);


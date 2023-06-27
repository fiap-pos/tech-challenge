CREATE TABLE IF NOT EXISTS produto (
    id bigint NOT NULL AUTO_INCREMENT,
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

CREATE TABLE IF NOT EXISTS pedido (
  id int AUTO_INCREMENT,
  status enum ('PENDENTE_DE_PAGAMENTO','PAGO','RECEBIDO','EM_PREPARACAO','PRONTO','FINALIZADO','CANCELADO'),
  data timestamp NOT NULL,
  cliente_id int NOT NULL,
  valor_total double,
  primary key (id),
  FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS item_pedido (
  id int AUTO_INCREMENT,
  pedido_id int NOT NULL,
  produto_id bigint NOT NULL,
  quantidade int NOT NULL,
  primary key (id),
  FOREIGN KEY (pedido_id) REFERENCES pedido (id),
  FOREIGN KEY (produto_id) REFERENCES produto (id)
);


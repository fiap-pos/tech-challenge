package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface CriaProdutoInputPort {

    ProdutoDTO criar(ProdutoDTO produto);
}

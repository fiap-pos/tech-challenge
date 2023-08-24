package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface EditaProdutoInputPort {

    ProdutoDTO editar(ProdutoDTO produto, Long id);
}

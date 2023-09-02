package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface RemoveProdutoInputPort {

    ProdutoDTO remover(Long id);
}

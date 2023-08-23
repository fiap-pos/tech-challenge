package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface RemoveProdutoOutputPort {

    ProdutoOut remover(Long id);
}

package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface RemoveProdutoOutputPort {

    ProdutoOut remover(Long id);
}

package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface RemoveProdutoInputPort {

    ProdutoOut remover(Long id);
}

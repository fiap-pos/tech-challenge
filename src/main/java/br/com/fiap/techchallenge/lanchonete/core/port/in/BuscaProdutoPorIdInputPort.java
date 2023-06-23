package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface BuscaProdutoPorIdInputPort {

    ProdutoOut buscarPorId(Long id);
}

package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;

public interface BuscaProdutoPorIdOutputPort {

    ProdutoOut buscarPorId(Long id);
}

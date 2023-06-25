package br.com.fiap.techchallenge.lanchonete.core.port.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

public interface BuscaProdutoPorIdOutputPort {

    ProdutoOut buscarPorId(Long id);
}

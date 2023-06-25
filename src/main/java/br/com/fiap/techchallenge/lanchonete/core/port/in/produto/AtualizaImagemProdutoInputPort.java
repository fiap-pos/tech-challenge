package br.com.fiap.techchallenge.lanchonete.core.port.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

public interface AtualizaImagemProdutoInputPort {

    ProdutoOut atualizar(ProdutoIn produtoIn);
}

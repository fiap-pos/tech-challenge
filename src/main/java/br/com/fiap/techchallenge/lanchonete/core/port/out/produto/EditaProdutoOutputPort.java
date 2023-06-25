package br.com.fiap.techchallenge.lanchonete.core.port.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;

public interface EditaProdutoOutputPort {

    ProdutoOut editar(ProdutoIn produtoIn);
}

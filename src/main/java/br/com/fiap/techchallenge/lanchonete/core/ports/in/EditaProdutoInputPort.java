package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;

public interface EditaProdutoInputPort {

    ProdutoOut editar(ProdutoIn produtoIn);
}

package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;

public interface SalvaProdutoOutputPort {

    ProdutoResponse salvar(ProdutoRequest produtoRequest);
}

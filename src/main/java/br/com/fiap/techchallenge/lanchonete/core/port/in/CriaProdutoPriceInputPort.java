package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;

public interface CriaProdutoPriceInputPort {

    ProdutoResponse criar(ProdutoRequest produtoRequest);
}

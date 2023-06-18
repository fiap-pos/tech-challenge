package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaProdutoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaProdutoPorIdOutputPort;

public class BuscaProdutoPorIdUseCase implements BuscaProdutoPorIdInputPort {

    BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    public BuscaProdutoPorIdUseCase(BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort) {
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public ProdutoOut buscarPorId(ProdutoIn produtoIn) {
        return buscaProdutoPorIdOutputPort.buscarPorId(produtoIn);
    }
}

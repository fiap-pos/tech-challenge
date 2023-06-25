package br.com.fiap.techchallenge.lanchonete.core.usecase.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.produto.BuscaProdutoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.BuscaProdutoPorIdOutputPort;

public class BuscaProdutoPorIdUseCase implements BuscaProdutoPorIdInputPort {

    BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort;

    public BuscaProdutoPorIdUseCase(BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort) {
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public ProdutoOut buscarPorId(Long id) {
        return buscaProdutoPorIdOutputPort.buscarPorId(id);
    }
}

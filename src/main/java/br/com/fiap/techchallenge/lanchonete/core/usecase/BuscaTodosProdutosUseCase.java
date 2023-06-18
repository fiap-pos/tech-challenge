package br.com.fiap.techchallenge.lanchonete.core.usecase;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaTodosProdutosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosProdutosOutputPort;

import java.util.List;

public class BuscaTodosProdutosUseCase implements BuscaTodosProdutosInputPort {

    BuscaTodosProdutosOutputPort buscaProdutoPorIdOutputPort;

    public BuscaTodosProdutosUseCase(BuscaTodosProdutosOutputPort buscaProdutoPorIdOutputPort) {
        this.buscaProdutoPorIdOutputPort = buscaProdutoPorIdOutputPort;
    }

    @Override
    public List<ProdutoOut> buscartodos() {
        return buscaProdutoPorIdOutputPort.buscarTodos();
    }
}

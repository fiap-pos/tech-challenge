package br.com.fiap.techchallenge.lanchonete.core.usecase.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.produto.BuscaTodosProdutosInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.BuscaTodosProdutosOutputPort;

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

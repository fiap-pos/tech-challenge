package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.BuscaProdutoPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.BuscaProdutoPorIdOutputPort;

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

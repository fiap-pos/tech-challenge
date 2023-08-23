package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.RemoveProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.RemoveProdutoOutputPort;

public class RemoveProdutoUseCase implements RemoveProdutoInputPort {

    RemoveProdutoOutputPort removeProdutoOutputPort;

    public RemoveProdutoUseCase(RemoveProdutoOutputPort removeProdutoOutputPort) {
        this.removeProdutoOutputPort = removeProdutoOutputPort;
    }

    @Override
    public ProdutoOut remover(Long id) {
        return removeProdutoOutputPort.remover(id);
    }
}

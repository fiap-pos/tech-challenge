package br.com.fiap.techchallenge.lanchonete.core.usecase.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.produto.RemoveProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.RemoveProdutoOutputPort;

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

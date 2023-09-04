package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.RemoveProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.RemoveProdutoOutputPort;

public class RemoveProdutoUseCase implements RemoveProdutoInputPort {

    RemoveProdutoOutputPort removeProdutoOutputPort;

    public RemoveProdutoUseCase(RemoveProdutoOutputPort removeProdutoOutputPort) {
        this.removeProdutoOutputPort = removeProdutoOutputPort;
    }

    @Override
    public ProdutoDTO remover(Long id) {
        return removeProdutoOutputPort.remover(id);
    }
}

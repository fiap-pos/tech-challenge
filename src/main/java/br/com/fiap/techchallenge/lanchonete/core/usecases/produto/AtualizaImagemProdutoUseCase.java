package br.com.fiap.techchallenge.lanchonete.core.usecases.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.AtualizaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.AtualizaImagemProdutoOutputPort;

public class AtualizaImagemProdutoUseCase implements AtualizaImagemProdutoInputPort {

    AtualizaImagemProdutoOutputPort atualizaImagemProdutoOutputPort;

    public AtualizaImagemProdutoUseCase(AtualizaImagemProdutoOutputPort salvaProdutoOutputPort) {
        this.atualizaImagemProdutoOutputPort = salvaProdutoOutputPort;
    }

    @Override
    public ProdutoDTO atualizar(AtualizaImagemProdutoDTO imagemIn, Long id) {
        return atualizaImagemProdutoOutputPort.atualizar(imagemIn, id);
    }
}

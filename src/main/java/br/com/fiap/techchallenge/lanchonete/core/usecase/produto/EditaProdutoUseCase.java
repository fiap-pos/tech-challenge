package br.com.fiap.techchallenge.lanchonete.core.usecase.produto;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.produto.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.in.produto.EditaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.produto.EditaProdutoOutputPort;

public class EditaProdutoUseCase implements EditaProdutoInputPort {

    EditaProdutoOutputPort editaProdutoOutputPort;

    public EditaProdutoUseCase(EditaProdutoOutputPort editaProdutoOutputPort) {
        this.editaProdutoOutputPort = editaProdutoOutputPort;
    }

    @Override
    public ProdutoOut editar(ProdutoIn produtoIn) {
        return editaProdutoOutputPort.editar(produtoIn);
    }
}

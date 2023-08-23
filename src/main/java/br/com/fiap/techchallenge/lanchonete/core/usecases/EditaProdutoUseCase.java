package br.com.fiap.techchallenge.lanchonete.core.usecases;

import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.EditaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.EditaProdutoOutputPort;

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

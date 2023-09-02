package br.com.fiap.techchallenge.lanchonete.core.ports.in.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface AtualizaImagemProdutoInputPort {

    ProdutoDTO atualizar(AtualizaImagemProdutoDTO imagemIn, Long id);
}

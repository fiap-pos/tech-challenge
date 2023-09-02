package br.com.fiap.techchallenge.lanchonete.core.ports.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.AtualizaImagemProdutoDTO;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface AtualizaImagemProdutoOutputPort {

    ProdutoDTO atualizar(AtualizaImagemProdutoDTO imagenIn, Long id);
}

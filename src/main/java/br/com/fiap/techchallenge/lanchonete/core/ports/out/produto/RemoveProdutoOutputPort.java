package br.com.fiap.techchallenge.lanchonete.core.ports.out.produto;

import br.com.fiap.techchallenge.lanchonete.core.dtos.ProdutoDTO;

public interface RemoveProdutoOutputPort {

    ProdutoDTO remover(Long id);
}

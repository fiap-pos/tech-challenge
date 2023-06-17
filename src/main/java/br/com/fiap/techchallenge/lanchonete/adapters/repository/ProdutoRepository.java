package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaImagemProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoRepository implements SalvaProdutoOutputPort, SalvaImagemProdutoOutputPort {

    ProdutoJpaRepository produtoJpaRepository;
    ProdutoMapper produtoMapper;

    public ProdutoRepository(ProdutoJpaRepository produtoJpaRepository, ProdutoMapper produtoMapper) {
        this.produtoJpaRepository = produtoJpaRepository;
        this.produtoMapper = produtoMapper;
    }

    @Override
    public ProdutoOut salvar(ProdutoIn produtoIn) {
        var produto = produtoMapper.toProduto(produtoIn);
        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoResponse(produtoSalvo);
    }

    @Override
    public ProdutoOut salvar(ImagemProdutoIn imagemProdutoIn) {
        var produtoOptional = produtoJpaRepository.findById(imagemProdutoIn.getId());

        var produto = produtoOptional.orElseThrow(() ->
                new EntityNotFoundException("Produto com o id " + imagemProdutoIn.getId() + " não existe"));
        produto.setImagem(imagemProdutoIn.getImagem());
        var produtoSalvo = produtoJpaRepository.save(produto);

        return produtoMapper.toProdutoResponse(produtoSalvo);
    }

}

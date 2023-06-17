package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ImagemProdutoIn;

public record ImagemProdutoRequest(Long id, byte[] imagem) implements ImagemProdutoIn {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public byte[] getImagem() {
        return imagem;
    }
}

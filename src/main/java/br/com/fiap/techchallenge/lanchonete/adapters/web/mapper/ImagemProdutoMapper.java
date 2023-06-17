package br.com.fiap.techchallenge.lanchonete.adapters.web.mapper;

import br.com.fiap.techchallenge.lanchonete.adapters.web.ImagemProdutoRequest;
import org.springframework.stereotype.Component;

@Component("ImagemProdutoMapper")
public class ImagemProdutoMapper {

    public ImagemProdutoRequest toProdutoResponse(Long id, byte[] imagem) {
        return new ImagemProdutoRequest(id, imagem);
    }

}

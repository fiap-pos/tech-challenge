package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.adapters.web.mapper.ProdutoMapper;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProdutoController {

    CriaProdutoInputPort criaProdutoInputPort;
    ProdutoMapper produtoMapper;

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort, ProdutoMapper produtoMapper) {
        this.criaProdutoInputPort = criaProdutoInputPort;
        this.produtoMapper = produtoMapper;
    }

    @PostMapping("/produto")
    public ResponseEntity<ProdutoResponse> salvar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var produtoOut = criaProdutoInputPort.criar(produtoRequest);
        var produtoResponse = produtoMapper.toProdutoResponse(produtoOut);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoResponse.getId())
                .toUri();

        return ResponseEntity.created(uri).body(produtoResponse);
    }

}

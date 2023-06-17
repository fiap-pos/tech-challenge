package br.com.fiap.techchallenge.lanchonete.adapters.web;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoRequest;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ProdutoResponse;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoPriceInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProdutoController {

    CriaProdutoPriceInputPort produtoPriceInputPort;

    public ProdutoController(CriaProdutoPriceInputPort produtoPriceInputPort) {
        this.produtoPriceInputPort = produtoPriceInputPort;
    }

    @PostMapping("/produto")
    public ResponseEntity<Void> salvar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var response = produtoPriceInputPort.criar(produtoRequest);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}

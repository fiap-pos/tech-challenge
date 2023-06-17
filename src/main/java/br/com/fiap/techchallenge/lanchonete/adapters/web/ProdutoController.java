package br.com.fiap.techchallenge.lanchonete.adapters.web;

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

    public ProdutoController(CriaProdutoInputPort criaProdutoInputPort) {
        this.criaProdutoInputPort = criaProdutoInputPort;
    }

    @PostMapping("/produto")
    public ResponseEntity<Void> salvar(@Valid @RequestBody ProdutoRequest produtoRequest) {
        var response = criaProdutoInputPort.criar(produtoRequest);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

}

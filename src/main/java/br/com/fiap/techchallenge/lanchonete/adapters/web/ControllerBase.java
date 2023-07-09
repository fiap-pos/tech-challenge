package br.com.fiap.techchallenge.lanchonete.adapters.web;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

abstract class ControllerBase {
    URI getExpandedCurrentUri(String path, Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(path)
                .buildAndExpand(id)
                .toUri();
    }
}

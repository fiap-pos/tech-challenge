package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

public interface CadastraClienteOutputPort {
    ClienteOut cadastrar(ClienteIn cliente);
}
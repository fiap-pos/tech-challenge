package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

public interface AtualizaClienteInputPort {
    ClienteOut atualizar(ClienteIn cliente, Long id);
}

package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

public interface AtualizaClienteInputPort {
    ClienteOut atualizar(ClienteIn cliente, Long id);
}

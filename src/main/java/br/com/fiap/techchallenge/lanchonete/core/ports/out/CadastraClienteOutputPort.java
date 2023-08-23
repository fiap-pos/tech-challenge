package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

public interface CadastraClienteOutputPort {
    ClienteOut cadastrar(ClienteIn cliente);
}

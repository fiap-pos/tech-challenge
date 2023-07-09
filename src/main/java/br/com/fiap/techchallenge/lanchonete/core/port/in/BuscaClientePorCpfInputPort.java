package br.com.fiap.techchallenge.lanchonete.core.port.in;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

public interface BuscaClientePorCpfInputPort {
    ClienteOut buscar(String cpf);
}

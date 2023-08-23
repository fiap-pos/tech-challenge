package br.com.fiap.techchallenge.lanchonete.core.ports.in;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

public interface BuscaClientePorCpfInputPort {
    ClienteOut buscar(String cpf);
}

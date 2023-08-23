package br.com.fiap.techchallenge.lanchonete.core.ports.out;

import br.com.fiap.techchallenge.lanchonete.core.entities.ClienteOut;

public interface BuscaClientePorCpfOutputPort {
    ClienteOut buscar(String cpf);
}

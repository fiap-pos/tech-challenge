package br.com.fiap.techchallenge.lanchonete.core.port.out;

import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;

public interface BuscaClientePorCpfOutputPort {
    ClienteOut buscar(String cpf);
}

package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase
@Transactional
class ClienteRepositoryIT {

    @Autowired
    ClienteJpaRepository clienteJpaRepository;


    @Test
    void criarCliente() {
        var cliente = new Cliente(
                "Cliente 1",
                "94187479015",
                "cliente1@gmail.com");

        var clienteCriado = clienteJpaRepository.save(cliente);

        assertThat(clienteCriado)
                .isInstanceOf(Cliente.class)
                .isNotNull();
        assertThat(clienteCriado.getId()).isNotNull();
        assertThat(clienteCriado.getId()).isEqualTo(cliente.getId());
        assertThat(clienteCriado.getNome()).isEqualTo(cliente.getNome());
        assertThat(clienteCriado.getCpf()).isEqualTo(cliente.getCpf());
        assertThat(clienteCriado.getEmail()).isEqualTo(cliente.getEmail());
    }
}
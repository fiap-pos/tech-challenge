package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.AtualizaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaTodosClientesOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.CadastraClienteOutputPort;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;


@Repository
public class ClienteRepository implements AtualizaClienteOutputPort, BuscaClienteOutputPort, BuscaTodosClientesOutputPort, CadastraClienteOutputPort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper mapper;

    public ClienteRepository(ClienteJpaRepository clienteJpaRepository, ClienteMapper mapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClienteDTO atualizar(ClienteDTO cliente, Long id) {
        Cliente savedCliente = clienteJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cliente com Id %s não encontrado", id)));
        BeanUtils.copyProperties(cliente, savedCliente, "id");

        try {
            return mapper.toClienteDTO(clienteJpaRepository.save(savedCliente));
        } catch (TransactionSystemException ex) {
            throw new BadRequestException("Os campos email ou CPF estão inválidos");
        } catch (DataIntegrityViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF já foram cadastrados");
        }
    }

    @Override
    public ClienteDTO buscar(String cpf) {
        Cliente cliente = clienteJpaRepository.findByCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Cliente com CPF %s não encontrado", cpf))
                );

        return mapper.toClienteDTO(cliente);
    }

    @Override
    public ClienteDTO buscar(Long id) {
        Cliente cliente = clienteJpaRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Cliente com id %s não encontrado", id))
                );

        return mapper.toClienteDTO(cliente);
    }

    @Override
    public List<ClienteDTO> buscarTodos() {
        List<Cliente> clientes = clienteJpaRepository.findAll();
        return mapper.toClienteListDTO(clientes);
    }

    @Override
    public ClienteDTO cadastrar(ClienteDTO cliente) {
        try {
            Cliente savedCliente = clienteJpaRepository.save(mapper.toCliente(cliente));
            return mapper.toClienteDTO(savedCliente);
        } catch (ConstraintViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF estão inválidos");
        } catch (DataIntegrityViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF já foram cadastrados");
        }

    }
}

package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mapper.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.model.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.exception.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteIn;
import br.com.fiap.techchallenge.lanchonete.core.domain.models.ClienteOut;
import br.com.fiap.techchallenge.lanchonete.core.port.out.AtualizaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaClientePorCpfOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaTodosClientesOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CadastraClienteOutputPort;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;


@Repository
public class ClienteRepository implements AtualizaClienteOutputPort, BuscaClientePorCpfOutputPort, BuscaTodosClientesOutputPort, CadastraClienteOutputPort {

    private final ClienteJpaRepository clienteJpaRepository;
    private final ClienteMapper mapper;

    public ClienteRepository(ClienteJpaRepository clienteJpaRepository, ClienteMapper mapper) {
        this.clienteJpaRepository = clienteJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClienteOut atualizar(ClienteIn cliente, Long id) {
        Cliente savedCliente = clienteJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cliente com Id %s não encontrado", id)));
        BeanUtils.copyProperties(cliente, savedCliente, "id");

        try {
            return mapper.toClienteResponse(clienteJpaRepository.save(savedCliente));
        } catch (TransactionSystemException ex) {
            throw new BadRequestException("Os campos email ou CPF estão inválidos");
        } catch (DataIntegrityViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF já foram cadastrados");
        }
    }

    @Override
    public ClienteOut buscar(String cpf) {
        Cliente cliente = clienteJpaRepository.findByCpf(cpf)
                .orElseThrow(
                        () -> new EntityNotFoundException(String.format("Cliente com CPF %s não encontrado", cpf))
                );

        return mapper.toClienteResponse(cliente);
    }

    @Override
    public List<ClienteOut> buscarTodos() {
        List<Cliente> clientes = clienteJpaRepository.findAll();
        return mapper.toClienteListResponse(clientes);
    }

    @Override
    public ClienteOut cadastrar(ClienteIn cliente) {
        try {
            Cliente savedCliente = clienteJpaRepository.save(mapper.toCliente(cliente));
            return mapper.toClienteResponse(savedCliente);
        } catch (ConstraintViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF estão inválidos");
        } catch (DataIntegrityViolationException ex) {
            throw new BadRequestException("Os campos email ou CPF já foram cadastrados");
        }

    }
}

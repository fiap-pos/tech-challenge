package br.com.fiap.techchallenge.lanchonete.adapters.repository;

import br.com.fiap.techchallenge.lanchonete.adapters.repository.jpa.ClienteJpaRepository;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.mappers.ClienteMapper;
import br.com.fiap.techchallenge.lanchonete.adapters.repository.models.Cliente;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.BadRequestException;
import br.com.fiap.techchallenge.lanchonete.core.domain.exceptions.EntityNotFoundException;
import br.com.fiap.techchallenge.lanchonete.core.dtos.ClienteDTO;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.TransactionSystemException;

import java.util.List;
import java.util.Optional;

import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getCliente;
import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTO;
import static br.com.fiap.techchallenge.lanchonete.utils.ClienteHelper.getClienteDTOSemId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ClienteRepositoryTest {

    private ClienteRepository clienteRepository;

    @Mock
    ClienteJpaRepository clienteJpaRepository;

    @Mock
    ClienteMapper mapper;

    AutoCloseable openMocks;

    @BeforeEach
    void setup() {
        openMocks = MockitoAnnotations.openMocks(this);
        clienteRepository = new ClienteRepository(clienteJpaRepository, mapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        openMocks.close();
    }

    @Nested
    class atualizarCliente {

        @Test
        void atualizarComClienteEncontrado() {
            ClienteDTO clienteDTO = getClienteDTO();
            var clienteSalvo = getCliente();
            clienteSalvo.setId(1L);
            when(clienteJpaRepository.findById(anyLong())).thenReturn(Optional.of(clienteSalvo));
            when(clienteJpaRepository.save(clienteSalvo)).thenReturn(clienteSalvo);
            when(mapper.toClienteDTO(clienteSalvo)).thenReturn(clienteDTO);

            var clienteAtualizado = clienteRepository.atualizar(clienteDTO, clienteDTO.id());

            assertThat(clienteAtualizado).isNotNull().isInstanceOf(ClienteDTO.class);
            assertThat(clienteAtualizado.id()).isEqualTo(clienteSalvo.getId());
            assertThat(clienteAtualizado.nome()).isEqualTo(clienteSalvo.getNome());
            assertThat(clienteAtualizado.cpf()).isEqualTo(clienteSalvo.getCpf());
            assertThat(clienteAtualizado.email()).isEqualTo(clienteSalvo.getEmail());

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(clienteJpaRepository, times(1)).save(clienteSalvo);
            verify(mapper, times(1)).toClienteDTO(clienteSalvo);
        }

        @Test
        void atualizarSemClienteEncontrado_LancaExcecao() {
            var id = 99L;
            ClienteDTO clienteDTO = getClienteDTO();
            when(clienteJpaRepository.findById(anyLong())).thenReturn(Optional.empty());

            assertThatThrownBy(() -> clienteRepository.atualizar(clienteDTO, id))
                    .isInstanceOf(EntityNotFoundException.class)
                    .hasMessage(String.format("Cliente com Id %s não encontrado", id));

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(clienteJpaRepository, never()).save(any(Cliente.class));
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

        @Test
        void atualizar_ComCpfOuEmailInvalido_LancaExcecao() {
            var id = 1L;
            var cpf = "AAAAAAAA";
            var email = "aaaaa";
            ClienteDTO clienteDTO = getClienteDTO();
            var clienteSalvo = getCliente();
            clienteSalvo.setId(id);
            clienteSalvo.setCpf(cpf);
            clienteSalvo.setEmail(email);
            when(clienteJpaRepository.findById(anyLong())).thenReturn(Optional.of(clienteSalvo));
            when(clienteJpaRepository.save(clienteSalvo)).thenThrow(TransactionSystemException.class);

            assertThatThrownBy(() -> clienteRepository.atualizar(clienteDTO, id))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessage("Os campos email ou CPF estão inválidos");

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(clienteJpaRepository, times(1)).save(any(Cliente.class));
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

        @Test
        void atualizar_ComCpfOuEmailJaCadastrados_LancaExcecao() {
            var id = 1L;
            ClienteDTO clienteDTO = getClienteDTO();
            var clienteSalvo = getCliente();
            clienteSalvo.setId(id);
            when(clienteJpaRepository.findById(anyLong())).thenReturn(Optional.of(clienteSalvo));
            when(clienteJpaRepository.save(clienteSalvo)).thenThrow(DataIntegrityViolationException.class);

            assertThatThrownBy(() -> clienteRepository.atualizar(clienteDTO, id))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessage("Os campos email ou CPF já foram cadastrados");

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(clienteJpaRepository, times(1)).save(any(Cliente.class));
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }
    }


    @Nested
    class buscarCliente {

        @Test
        void buscarPorCPF() {
            var cpf = "11122233399";
            var cliente = getCliente();
            cliente.setId(1L);
            ClienteDTO clienteDTO = getClienteDTO();

            when(clienteJpaRepository.findByCpf(cpf)).thenReturn(Optional.of(cliente));
            when(mapper.toClienteDTO(cliente)).thenReturn(clienteDTO);

            var clienteEncontrado = clienteRepository.buscar(cpf);

            assertThat(clienteEncontrado).isNotNull().isInstanceOf(ClienteDTO.class);
            assertThat(clienteEncontrado.id()).isEqualTo(cliente.getId());
            assertThat(clienteEncontrado.nome()).isEqualTo(cliente.getNome());
            assertThat(clienteEncontrado.cpf()).isEqualTo(cliente.getCpf());
            assertThat(clienteEncontrado.email()).isEqualTo(cliente.getEmail());

            verify(clienteJpaRepository, times(1)).findByCpf(anyString());
            verify(mapper, times(1)).toClienteDTO(cliente);
        }

        @Test
        void buscarPorCPF_LanceExcecao_SeNaoEncontrado() {
            var cpf = "99999999999";
            var cliente = getCliente();
            cliente.setId(1L);

            when(clienteJpaRepository.findByCpf(cpf)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> clienteRepository.buscar(cpf))
                    .isInstanceOf(EntityNotFoundException.class)
                    .hasMessage(String.format("Cliente com CPF %s não encontrado", cpf));

            verify(clienteJpaRepository, times(1)).findByCpf(anyString());
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

        @Test
        void buscarPorId() {
            var id = 1L;
            var cliente = getCliente();
            cliente.setId(id);
            ClienteDTO clienteDTO = getClienteDTO();

            when(clienteJpaRepository.findById(id)).thenReturn(Optional.of(cliente));
            when(mapper.toClienteDTO(cliente)).thenReturn(clienteDTO);

            var clienteEncontrado = clienteRepository.buscar(id);

            assertThat(clienteEncontrado).isNotNull().isInstanceOf(ClienteDTO.class);
            assertThat(clienteEncontrado.id()).isEqualTo(cliente.getId());
            assertThat(clienteEncontrado.nome()).isEqualTo(cliente.getNome());
            assertThat(clienteEncontrado.cpf()).isEqualTo(cliente.getCpf());
            assertThat(clienteEncontrado.email()).isEqualTo(cliente.getEmail());

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(mapper, times(1)).toClienteDTO(cliente);
        }

        @Test
        void buscarPorId_LanceExcecao_SeNaoEncontrado() {
            var id = 99L;
            var cliente = getCliente();
            cliente.setId(id);

            when(clienteJpaRepository.findById(id)).thenReturn(Optional.empty());

            assertThatThrownBy(() -> clienteRepository.buscar(id))
                    .isInstanceOf(EntityNotFoundException.class)
                    .hasMessage(String.format("Cliente com id %s não encontrado", id));

            verify(clienteJpaRepository, times(1)).findById(anyLong());
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

        @Test
        void buscarTodos() {
            var id = 1L;
            var cliente = getCliente();
            cliente.setId(id);
            var todosClientes = List.of(cliente);
            var todosClientesDTO = List.of(getClienteDTO());

            when(clienteJpaRepository.findAll()).thenReturn(todosClientes);
            when(mapper.toClienteListDTO(todosClientes)).thenReturn(todosClientesDTO);

            var todosClientesEncontrados = clienteRepository.buscarTodos();

            assertThat(todosClientesEncontrados).isNotNull();
            assertThat(todosClientesEncontrados).allSatisfy( clienteEncontrado -> {
                assertThat(clienteEncontrado.id()).isEqualTo(todosClientes.get(0).getId());
                assertThat(clienteEncontrado.nome()).isEqualTo(todosClientes.get(0).getNome());
                assertThat(clienteEncontrado.cpf()).isEqualTo(todosClientes.get(0).getCpf());
                assertThat(clienteEncontrado.email()).isEqualTo(todosClientes.get(0).getEmail());
            });

            verify(clienteJpaRepository, times(1)).findAll();
            verify(mapper, times(1)).toClienteListDTO(todosClientes);
        }

    }


    @Nested
    class cadastrarCliente {
        @Test
        void cadastrar() {
            ClienteDTO clienteDTO = getClienteDTOSemId();
            Cliente clienteSalvo = getCliente();
            clienteSalvo.setId(1L);
            when(mapper.toCliente(clienteDTO)).thenReturn(clienteSalvo);
            when(clienteJpaRepository.save(clienteSalvo)).thenReturn(clienteSalvo);
            when(mapper.toClienteDTO(clienteSalvo)).thenReturn(clienteDTO);

            var novoCliente = clienteRepository.cadastrar(clienteDTO);

            assertThat(novoCliente).isNotNull().isInstanceOf(ClienteDTO.class);
            assertThat(novoCliente.nome()).isEqualTo(clienteSalvo.getNome());
            assertThat(novoCliente.cpf()).isEqualTo(clienteSalvo.getCpf());
            assertThat(novoCliente.email()).isEqualTo(clienteSalvo.getEmail());

            verify(mapper, times(1)).toCliente(clienteDTO);
            verify(clienteJpaRepository, times(1)).save(clienteSalvo);
            verify(mapper, times(1)).toClienteDTO(clienteSalvo);
        }

        @Test
        void cadastrar_seEmailOuCPFInvalido_LancaExcecao() {
            ClienteDTO clienteDTO = getClienteDTOSemId();
            Cliente clienteSalvo = getCliente();
            clienteSalvo.setId(1L);
            when(mapper.toCliente(clienteDTO)).thenReturn(clienteSalvo);
            when(clienteJpaRepository.save(clienteSalvo)).thenThrow(ConstraintViolationException.class);

            assertThatThrownBy(() -> clienteRepository.cadastrar(clienteDTO))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessage("Os campos email ou CPF estão inválidos");

            verify(mapper, times(1)).toCliente(clienteDTO);
            verify(clienteJpaRepository, times(1)).save(clienteSalvo);
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

        @Test
        void cadastrar_seEmailOuCPFJaCadastrado_LancaExcecao() {
            ClienteDTO clienteDTO = getClienteDTOSemId();
            Cliente clienteSalvo = getCliente();
            clienteSalvo.setId(1L);
            when(mapper.toCliente(clienteDTO)).thenReturn(clienteSalvo);
            when(clienteJpaRepository.save(clienteSalvo)).thenThrow(DataIntegrityViolationException.class);

            assertThatThrownBy(() -> clienteRepository.cadastrar(clienteDTO))
                    .isInstanceOf(BadRequestException.class)
                    .hasMessage("Os campos email ou CPF já foram cadastrados");

            verify(mapper, times(1)).toCliente(clienteDTO);
            verify(clienteJpaRepository, times(1)).save(clienteSalvo);
            verify(mapper, never()).toClienteDTO(any(Cliente.class));
        }

    }
}
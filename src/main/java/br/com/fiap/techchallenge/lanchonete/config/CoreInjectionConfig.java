package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.AtualizaClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaClientePorInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.BuscaTodosClientesInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.cliente.CadastraClienteInputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.pedido.*;
import br.com.fiap.techchallenge.lanchonete.core.ports.in.produto.*;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.AtualizaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.BuscaTodosClientesOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.cliente.CadastraClienteOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.pedido.*;
import br.com.fiap.techchallenge.lanchonete.core.ports.out.produto.*;
import br.com.fiap.techchallenge.lanchonete.core.usecases.cliente.AtualizaClienteUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecases.cliente.BuscaClientePorUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecases.cliente.BuscaTodosClientesUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecases.cliente.CadastraClienteUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecases.pedido.*;
import br.com.fiap.techchallenge.lanchonete.core.usecases.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjectionConfig {

    @Bean
    CriaProdutoInputPort criarProduto(CriaProdutoOutputPort criaProdutoOutputPort) {
        return new CriaProdutoUseCase(criaProdutoOutputPort);
    }

    @Bean
    AtualizaImagemProdutoInputPort criarImagemProduto(AtualizaImagemProdutoOutputPort atualizaImagemProdutoOutputPort) {
        return new AtualizaImagemProdutoUseCase(atualizaImagemProdutoOutputPort);
    }

    @Bean
    EditaProdutoInputPort editarProduto(EditaProdutoOutputPort editaProdutoOutputPort) {
        return new EditaProdutoUseCase(editaProdutoOutputPort);
    }

    @Bean
    RemoveProdutoInputPort removerProduto(RemoveProdutoOutputPort removeProdutoOutputPort) {
        return new RemoveProdutoUseCase(removeProdutoOutputPort);
    }

    @Bean
    BuscaProdutoPorIdInputPort buscarProdutoPorId(BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort) {
        return new BuscaProdutoPorIdUseCase(buscaProdutoPorIdOutputPort);
    }

    @Bean
    BuscaTodosProdutosInputPort buscarTodos(BuscaTodosProdutosOutputPort buscaProdutoPorIdOutputPort) {
        return new BuscaTodosProdutosUseCase(buscaProdutoPorIdOutputPort);
    }

    @Bean
    BuscaProdutoPorCategoriaInputPort buscarPorCategoria(BuscaProdutoPorCategoriaOutputPort buscaProdutoPorIdOutputPort) {
        return new BuscaProdutoPorCategoriaUseCase(buscaProdutoPorIdOutputPort);
    }

    @Bean
    AtualizaClienteInputPort atualizaCliente(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        return new AtualizaClienteUseCase(atualizaClienteOutputPort);
    }

    @Bean
    BuscaClientePorInputPort buscaClientePorCpf(BuscaClienteOutputPort buscaClienteOutputPort) {
        return new BuscaClientePorUseCase(buscaClienteOutputPort);
    }

    @Bean
    BuscaTodosClientesInputPort buscaTodosClientes(BuscaTodosClientesOutputPort buscaTodosClientesOutputPort) {
        return new BuscaTodosClientesUseCase(buscaTodosClientesOutputPort);
    }

    @Bean
    CadastraClienteInputPort cadastraCliente(CadastraClienteOutputPort cadastraClienteOutputPort) {
        return new CadastraClienteUseCase(cadastraClienteOutputPort);
    }

    @Bean
    CriaPedidoInputPort criarPedido(
            CriaPedidoOutputPort criaPedidoOutputPort,
            BuscaProdutoPorIdOutputPort buscaProdutoPorIdOutputPort,
            BuscaClienteOutputPort buscaClienteOutputPort
    ) {
        return new CriaPedidoUseCase(criaPedidoOutputPort, buscaProdutoPorIdOutputPort, buscaClienteOutputPort);
    }

    @Bean
    AtualizaStatusPedidoInputPort atualizaStatusPedido(AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort){
        return new AtualizaStatusPedidoUseCase(atualizaStatusPedidoOutputPort);
    }

    @Bean
    BuscarPedidoPorIdInputPort buscarPedidoPorId(BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort){
        return new BuscarPedidoPorIdUseCase(buscarPedidoPorIdOutputPort);
    }
    @Bean
    BuscaTodosPedidosInputPort buscarTodosPedidos(BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        return new BuscaTodosPedidosUseCase(buscaTodosPedidosOutputPort);
    }

//    @Bean
//    CriaQrCodeOutputPort criaQrCodeInputPort(){
//        return new PagamentoMock();
//    }
//
//    @Bean
//    BuscaCobrancaPorIdInputPort buscaCobrancaPorId(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
//        return new BuscaCobrancaPorIdUseCase(buscaCobrancaOutputPort);
//    }
//
//    @Bean
//    BuscaCobrancaPorPedidoIdInputPort buscarCobrancaPorPedidoId(BuscaCobrancaOutputPort buscaCobrancaOutputPort) {
//        return new BuscaCobrancaPorPedidoIdUseCase(buscaCobrancaOutputPort);
//    }
//    @Bean
//    CriaCobrancaInputPort criarCobranca(
//            CriaCobrancaOutputPort criaCobrancaOutputPort,
//            CriaQrCodeOutputPort criaQrCodeOutputPort,
//            BuscarPedidoPorIdOutputPort buscarPedidoPorIdOutputPort,
//            BuscaCobrancaOutputPort buscaCobrancaOutputPort
//    ) {
//        return new CriaCobrancaUseCase(
//                criaCobrancaOutputPort,
//                criaQrCodeOutputPort,
//                buscarPedidoPorIdOutputPort,
//                buscaCobrancaOutputPort
//        );
//    }

//    @Bean
//    AtualizaStatusCobrancaInputPort atualiStatusCobranca(
//            AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort,
//            BuscaCobrancaOutputPort buscaCobrancaOutputPort,
//            AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort
//    ) {
//        return new AtualizaStatusCobrancaUseCase(
//                buscaCobrancaOutputPort,
//                atualizaStatusCobrancaOutputPort,
//                atualizaStatusPedidoOutputPort
//        );
//    }

    @Bean
    BuscaTodosPedidosPorStatusInputPort buscarPorStatus(BuscaTodosPedidosPorStatusOutputPort buscaTodosPedidosOutputPort) {
        return new BuscaTodosPedidosPorStatusUseCase(buscaTodosPedidosOutputPort);
    }

//    @Bean
//    BuscaStatusPagamentoInputPort buscaStatusPagamento(BuscaStatusPagamentoOutputPort buscaStatusPagamentoOutputPort) {
//        return new BuscaStatusPagamentoUseCase(buscaStatusPagamentoOutputPort);
//    }
    @Bean
    BuscaPedidosOrdenadosPorPrioridadeInputPort ordenaPorPrioridade(BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        return new BuscaPedidosPorPrioridadeUseCase(buscaTodosPedidosOutputPort);
    }
}

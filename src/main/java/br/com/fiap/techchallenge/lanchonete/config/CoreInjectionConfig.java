package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.*;
import br.com.fiap.techchallenge.lanchonete.core.port.in.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.*;
import br.com.fiap.techchallenge.lanchonete.core.port.out.BuscaCobrancaPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.usecase.*;
import br.com.fiap.techchallenge.lanchonete.core.usecase.BuscaCobrancaPorIdUserCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaCobrancaUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaQrCodeUseCase;
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
    CriaPedidoInputPort criarPedido(CriaPedidoOutputPort criaPedidoOutputPort) {
        return new CriaPedidoUseCase(criaPedidoOutputPort);
    }

    @Bean
    BuscaTodosPedidosInputPort buscarTodosPedidos(BuscaTodosPedidosOutputPort buscaTodosPedidosOutputPort) {
        return new BuscaTodosPedidosUseCase(buscaTodosPedidosOutputPort);
    }

    @Bean
    BuscaPedidoPorClienteIdInputPort buscaPedidoPorCliente(BuscaPedidoPorClienteIdOutputPort buscaPedidoPorClienteIdOutputPort){
        return new BuscaPedidoPorClienteIdUseCase(buscaPedidoPorClienteIdOutputPort);
    }

    @Bean
    AtualizaStatusPedidoInputPort atualizaStatusPedido(AtualizaStatusPedidoOutputPort atualizaStatusPedidoOutputPort){
        return new AtualizaStatusPedidoUseCase(atualizaStatusPedidoOutputPort);
    }

    @Bean
    CriaQrCodeInputPort criaQrCodeInputPort(){
        return new CriaQrCodeUseCase();
    }

    @Bean
    CriaCobrancaInputPort criarCobranca(CriaCobrancaOutputPort criaCobrancaOutputPort, CriaQrCodeInputPort criaQrCodeInputPort) {
        return new CriaCobrancaUseCase(criaCobrancaOutputPort, criaQrCodeInputPort);
    }

    @Bean
    BuscaCobrancaPorIdInputPort buscaCobrancaPorId(BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort) {
        return new BuscaCobrancaPorIdUserCase(buscaCobrancaPorIdOutputPort);
    }

    @Bean
    AtualizaStatusCobrancaInputPort atualiStatusCobranca(
            AtualizaStatusCobrancaOutputPort atualizaStatusCobrancaOutputPort,
            BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort
    ) {
        return new AtualizaStatusCobrancaUseCase(buscaCobrancaPorIdOutputPort, atualizaStatusCobrancaOutputPort);
    }
}

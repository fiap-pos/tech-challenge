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
    AtualizaClienteInputPort atualizaCliente(AtualizaClienteOutputPort atualizaClienteOutputPort) {
        return new AtualizaClienteUseCase(atualizaClienteOutputPort);
    }

    @Bean
    BuscaClientePorCpfInputPort buscaClientePorCpf(BuscaClientePorCpfOutputPort buscaClientePorCpfOutputPort) {
        return new BuscaClientePorCpfUseCase(buscaClientePorCpfOutputPort);
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

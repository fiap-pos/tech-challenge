package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.*;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.BuscaCobrancaPorIdInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.cobranca.CriaCobrancaInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.*;
import br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca.BuscaCobrancaPorIdOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.cobranca.CriaCobrancaOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.usecase.*;
import br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca.BuscaCobrancaPorIdUserCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca.CriaCobrancaUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.cobranca.CriaQrCodeUseCase;
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
    CriaCobrancaInputPort criarCobranca(CriaCobrancaOutputPort criaCobrancaOutputPort) {
        return new CriaCobrancaUseCase(criaCobrancaOutputPort, new CriaQrCodeUseCase());
    }

    @Bean
    BuscaCobrancaPorIdInputPort buscaCobrancaPorId(BuscaCobrancaPorIdOutputPort buscaCobrancaPorIdOutputPort) {
        return new BuscaCobrancaPorIdUserCase(buscaCobrancaPorIdOutputPort);
    }


}

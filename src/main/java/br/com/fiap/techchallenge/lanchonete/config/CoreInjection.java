package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.*;
import br.com.fiap.techchallenge.lanchonete.core.port.out.*;
import br.com.fiap.techchallenge.lanchonete.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {

    @Bean
    CriaProdutoInputPort criarProduto(CriaProdutoOutputPort criaProdutoOutputPort) {
        return new CriaProdutoUseCase(criaProdutoOutputPort);
    }

    @Bean
    CriaImagemProdutoInputPort criarImagemProduto(CriaImagemProdutoOutputPort criaImagemProdutoOutputPort) {
        return new CriaImagemProdutoUseCase(criaImagemProdutoOutputPort);
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

}

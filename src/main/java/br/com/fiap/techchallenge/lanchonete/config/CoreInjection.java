package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaImagemProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.EditaProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.in.RemoveProdutoInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaImagemProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.CriaProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.EditaProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.RemoveProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaImagemProdutoUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaProdutoUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.EditaProdutoUseCase;
import br.com.fiap.techchallenge.lanchonete.core.usecase.RemoveProdutoUseCase;
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

}

package br.com.fiap.techchallenge.lanchonete.config;

import br.com.fiap.techchallenge.lanchonete.core.port.in.CriaProdutoPriceInputPort;
import br.com.fiap.techchallenge.lanchonete.core.port.out.SalvaProdutoOutputPort;
import br.com.fiap.techchallenge.lanchonete.core.usecase.CriaProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreInjection {

    @Bean
    CriaProdutoPriceInputPort criarProduto(SalvaProdutoOutputPort salvaProdutoOutputPort) {
        return new CriaProdutoUseCase(salvaProdutoOutputPort);
    }
}

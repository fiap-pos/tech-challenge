package br.com.fiap.techchallenge.lanchonete.bdd;

import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.FilaProducaoListener;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.PagamentosListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@ActiveProfiles({"test", "cucumber"})
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberSpringIntegrationTest {

    @LocalServerPort
    private int port;

    @MockBean
    SqsAsyncClient sqsAsyncClient;

    @MockBean
    FilaProducaoListener filaProducaoListener;

    @MockBean
    PagamentosListener pagamentosListener;

}
package br.com.fiap.techchallenge.lanchonete.bdd;

import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.FilaProducaoListener;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.PagamentosListener;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@CucumberContextConfiguration
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CucumberSpringIntegrationTest {

    @MockBean
    SqsAsyncClient sqsAsyncClient;

    @MockBean
    FilaProducaoListener filaProducaoListener;

    @MockBean
    PagamentosListener pagamentosListener;

    AutoCloseable mock;

    @BeforeEach
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
    }


    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }
}
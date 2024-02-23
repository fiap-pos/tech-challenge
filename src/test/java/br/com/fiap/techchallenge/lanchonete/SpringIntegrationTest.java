package br.com.fiap.techchallenge.lanchonete;

import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.FilaProducaoListener;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.PagamentosListener;
import io.restassured.RestAssured;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@Transactional
@ExtendWith(MockitoExtension.class)
public class SpringIntegrationTest {

    @LocalServerPort
    private int port;

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
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @AfterEach
    void tearDown() throws Exception {
        mock.close();
    }
}
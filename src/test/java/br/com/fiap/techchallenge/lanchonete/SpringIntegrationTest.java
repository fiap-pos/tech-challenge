package br.com.fiap.techchallenge.lanchonete;

import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.FilaProducaoListener;
import br.com.fiap.techchallenge.lanchonete.adapters.messages.listeners.PagamentosListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import com.maciejwalkowiak.wiremock.spring.InjectWireMock;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
@ActiveProfiles("test")
@EnableWireMock({
        @ConfigureWireMock(name = "wiremock-service", property = "wiremock-client.url", port = 9999)
})
@Transactional
public abstract class SpringIntegrationTest {

    @LocalServerPort
    private int port;

    @InjectWireMock("wiremock-service")
    protected WireMockServer wiremock;

    protected ObjectMapper objectMapper;

    @MockBean
    SqsAsyncClient sqsAsyncClient;

    @MockBean
    FilaProducaoListener filaProducaoListener;

    @MockBean
    PagamentosListener pagamentosListener;

    AutoCloseable mock;

    @BeforeEach
    @Before
    void setUp() {
        mock = MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @AfterEach
    @After
    void tearDown() throws Exception {
        mock.close();
        wiremock.resetAll();
    }
}
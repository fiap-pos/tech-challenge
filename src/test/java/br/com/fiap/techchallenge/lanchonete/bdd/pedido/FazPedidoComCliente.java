package br.com.fiap.techchallenge.lanchonete.bdd.pedido;

import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserResponse;
import br.com.fiap.techchallenge.lanchonete.adapters.gateways.auth.models.UserRole;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.ItemPedidoRequest;
import br.com.fiap.techchallenge.lanchonete.adapters.web.models.requests.PedidoRequest;
import br.com.fiap.techchallenge.lanchonete.bdd.CucumberSpringIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class FazPedidoComCliente extends CucumberSpringIntegrationTest {

    private Response response;

    private final String ENDPOINT_API_PEDIDOS = "/pedidos";

    private ObjectMapper objectMapper = new ObjectMapper();

    private WireMockServer wiremock;

    @Before
    public void setUpAll() {
        wiremock = new WireMockServer(8888);
        wiremock.start();

        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @After
    public void tearDownAll() {
        wiremock.stop();
    }

    @AfterStep
    public void tearDown() {
        wiremock.resetAll();
    }

    @Quando("criar um novo pedido com cliente")
    public void criar_um_novo_pedido_com_cliente() throws JsonProcessingException {

        var userResponse = new UserResponse(
                "id-cliente",
                "Novo Cliente",
                "12345678901",
                "email@cliente.com",
                List.of(UserRole.CUSTOMER)
        );

        var authorization = "Bearer token-customer";
        mockAuthGatewayRequest(authorization, userResponse.id(), objectMapper.writeValueAsString(userResponse));


        var itemPedidoRequest1 = new ItemPedidoRequest(1L, 2);
        var itemPedidoRequest2 = new ItemPedidoRequest(2L, 2);
        var pedidoRequest = new PedidoRequest(List.of(itemPedidoRequest1, itemPedidoRequest2));

        response = given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("Authorization", authorization)
                .body(pedidoRequest)
                .post(ENDPOINT_API_PEDIDOS);
    }

    @Então("o pedido é criado com sucesso com cliente apresentado")
    public void o_pedido_é_criado_com_sucesso_com_cliente_apresentado() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @E("deve ser apresentado com cliente")
    public void deve_ser_apresentado_com_cliente() {
        response.then()
                .log().all()
                .body(matchesJsonSchemaInClasspath("schemas/pedido-com-cliente.schema.json"));
    }

    private void mockAuthGatewayRequest(String authorization, String id, String response) {
        wiremock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/auth/info"))
                        .withHeader("Authorization", WireMock.equalTo(authorization))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(response)
                        )
        );

        wiremock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/users/" + id))
                        .willReturn(
                                WireMock.aResponse()
                                        .withStatus(200)
                                        .withHeader("Content-Type", "application/json")
                                        .withBody(response)
                        )
        );
    }

}
